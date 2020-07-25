/*
 * Copyright 2015, 2019 StreamEx contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.java8.userful.streamex;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

import static one.util.streamex.Internals.*;

/**
 * @author Tagir Valeev
 *
 */
/* package */ abstract class TreeSpliterator<T, U> extends CloneableSpliterator<U, TreeSpliterator<T, U>> 
        implements Consumer<T>, AutoCloseable, Runnable {
    private static final int MAX_RECURSION_DEPTH = Integer.getInteger("one.util.streamex.tree.recursiondepth", 128);
    T cur;
    List<PairBox<Spliterator<T>, Stream<T>>> spliterators;
    private Runnable closeHandler = null;
    long size = Long.MAX_VALUE;

    TreeSpliterator(T root) {
        this.cur = root;
    }
    
    boolean advance() {
        List<PairBox<Spliterator<T>, Stream<T>>> spltrs = spliterators;
        if (spltrs == null) {
            spliterators = new ArrayList<>();
            return true;
        }
        for (int lastIdx = spltrs.size() - 1; lastIdx >= 0; lastIdx--) {
            PairBox<Spliterator<T>, Stream<T>> pair = spltrs.get(lastIdx);
            Spliterator<T> spltr = pair.a;
            if (spltr.tryAdvance(this)) {
                return true;
            }
            if (pair.b != null)
                pair.b.close();
            spltrs.remove(lastIdx);
        }
        return false;
    }

    boolean append(Stream<T> stream) {
        if (stream != null) {
            spliterators.add(new PairBox<>(stream.spliterator(), stream));
        }
        return true;
    }
    
    abstract Stream<T> getStart();
    
    abstract U getStartElement();

    @Override
    public Spliterator<U> trySplit() {
        if (spliterators == null) {
            spliterators = new ArrayList<>();
            Stream<T> stream = getStart();
            if (stream != null) {
                spliterators.add(new PairBox<>(stream.parallel().spliterator(), null));
                closeHandler = stream::close;
            }
            return new ConstSpliterator.OfRef<>(getStartElement(), 1, true);
        }
        int size = spliterators.size();
        if (size != 1) {
            return null;
        }
        Spliterator<T> prefix = spliterators.get(0).a.trySplit();
        if (prefix == null)
            return null;
        TreeSpliterator<T, U> clone = doClone();
        clone.size /= 2;
        this.size -= clone.size;
        clone.spliterators = new ArrayList<>();
        clone.spliterators.add(new PairBox<>(prefix, null));
        closeHandler = StreamContext.compose(closeHandler, clone);
        return clone;
    }
    
    @Override
    public long estimateSize() {
        return size;
    }

    @Override
    public int characteristics() {
        return ORDERED;
    }

    @Override
    public void accept(T t) {
        cur = t;
    }
    
    @Override
    public void run() {
        close();
    }
    
    @Override
    public void close() {
        if (spliterators != null) {
            Throwable t = null;
            for (int i = spliterators.size() - 1; i >= 0; i--) {
                try {
                    Stream<T> stream = spliterators.get(i).b;
                    if (stream != null)
                        stream.close();
                } catch (Error | RuntimeException e) {
                    if (t == null)
                        t = e;
                    else
                        t.addSuppressed(e);
                }
            }
            if (closeHandler != null) {
                try {
                    closeHandler.run();
                } catch (Error | RuntimeException e) {
                    if (t == null)
                        t = e;
                    else
                        t.addSuppressed(e);
                }
            }
            if (t instanceof RuntimeException)
                throw (RuntimeException) t;
            if (t instanceof Error)
                throw (Error) t;
        }
    }
    
    static class Acceptor<T> implements Consumer<T> {
        private final Consumer<? super T> action;
        private final Function<T, Stream<T>> mapper;
        private int depth;
        
        public Acceptor(Consumer<? super T> action, Function<T, Stream<T>> mapper) {
            this.action = action;
            this.mapper = mapper;
        }
    
        @Override
        public void accept(T t) {
            if (depth > MAX_RECURSION_DEPTH) {
                try (TreeSpliterator<T, T> spliterator = new Plain<>(t, mapper)) {
                    do { // nothing
                    } while (spliterator.tryAdvance(action));
                }
                return;
            }
            action.accept(t);
            depth++;
            try (Stream<T> stream = mapper.apply(t)) {
                if (stream != null) {
                    stream.spliterator().forEachRemaining(this);
                }
            } finally {
                depth--;
            }
        }
    }

    static class Plain<T> extends TreeSpliterator<T, T> {
        private final Function<T, Stream<T>> mapper;

        Plain(T root, Function<T, Stream<T>> mapper) {
            super(root);
            this.mapper = mapper;
        }

        @Override
        public boolean tryAdvance(Consumer<? super T> action) {
            if (!advance())
                return false;
            T e = this.cur;
            action.accept(e);
            return append(mapper.apply(e));
        }
    
        @Override
        public void forEachRemaining(Consumer<? super T> action) {
            Acceptor<T> acceptor = new Acceptor<>(action, mapper);
            if (spliterators != null) {
                for (int i = spliterators.size() - 1; i >= 0; i--) {
                    PairBox<Spliterator<T>, Stream<T>> pair = spliterators.get(i);
                    pair.a.forEachRemaining(acceptor);
                    if (pair.b != null)
                        pair.b.close();
                }
            } else {
                spliterators = Collections.emptyList();
                acceptor.accept(cur);
            }
        }

        @Override
        Stream<T> getStart() {
            return mapper.apply(cur);
        }

        @Override
        T getStartElement() {
            return cur;
        }
    }
    
    static class DepthAcceptor<T> implements Consumer<T> {
        private final Consumer<? super Entry<Integer, T>> action;
        private final BiFunction<Integer, T, Stream<T>> mapper;
        private Integer depth;
        
        public DepthAcceptor(Consumer<? super Entry<Integer, T>> action, BiFunction<Integer, T, Stream<T>> mapper, Integer depth) {
            this.action = action;
            this.mapper = mapper;
            this.depth = depth;
        }
    
        @Override
        public void accept(T t) {
            if (depth > MAX_RECURSION_DEPTH) {
                try (TreeSpliterator<T, Entry<Integer, T>> spliterator = new Depth<>(t, mapper, depth)) {
                    do { // nothing
                    } while (spliterator.tryAdvance(action));
                }
                return;
            }
            action.accept(new AbstractMap.SimpleImmutableEntry<>(depth, t));
            try (Stream<T> stream = mapper.apply(depth, t)) {
                if (stream != null) {
                    depth++;
                    stream.spliterator().forEachRemaining(this);
                    depth--;
                }
            }
        }
    }

    static class Depth<T> extends TreeSpliterator<T, Entry<Integer, T>> {
        private final BiFunction<Integer, T, Stream<T>> mapper;
        private final int initialDepth;

        Depth(T root, BiFunction<Integer, T, Stream<T>> mapper, int depth) {
            super(root);
            this.mapper = mapper;
            initialDepth = depth;
        }

        @Override
        public boolean tryAdvance(Consumer<? super Entry<Integer, T>> action) {
            if (!advance())
                return false;
            T e = this.cur;
            int depth = initialDepth + spliterators.size();
            action.accept(new ObjIntBox<>(e, depth));
            return append(mapper.apply(depth, e));
        }

        @Override
        public void forEachRemaining(Consumer<? super Entry<Integer, T>> action) {
            DepthAcceptor<T> acceptor = new DepthAcceptor<>(action, mapper, initialDepth);
            if (spliterators != null) {
                for (int i = spliterators.size() - 1; i >= 0; i--) {
                    PairBox<Spliterator<T>, Stream<T>> pair = spliterators.get(i);
                    acceptor.depth = i + 1;
                    pair.a.forEachRemaining(acceptor);
                    if (pair.b != null)
                        pair.b.close();
                }
            } else {
                spliterators = Collections.emptyList();
                acceptor.accept(cur);
            }
        }

        @Override
        Stream<T> getStart() {
            return mapper.apply(0, cur);
        }

        @Override
        Entry<Integer, T> getStartElement() {
            return new ObjIntBox<>(cur, 0);
        }
    }
}
