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
package com.example.java8.streamex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.concurrent.ForkJoinPool;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collector;
import java.util.stream.Collector.Characteristics;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static com.example.java8.streamex.Internals.ArrayCollection;
import static com.example.java8.streamex.Internals.Box;
import static com.example.java8.streamex.Internals.CancelException;
import static com.example.java8.streamex.Internals.CancellableCollectorImpl;
import static com.example.java8.streamex.Internals.NONE;
import static com.example.java8.streamex.Internals.NO_CHARACTERISTICS;
import static com.example.java8.streamex.Internals.ObjDoubleBox;
import static com.example.java8.streamex.Internals.ObjIntBox;
import static com.example.java8.streamex.Internals.ObjLongBox;
import static com.example.java8.streamex.Internals.PairBox;
import static com.example.java8.streamex.Internals.finished;
import static com.example.java8.streamex.Internals.none;

/**
 * Base class providing common functionality for {@link StreamEx} and {@link EntryStream}.
 *
 * @param <T> the type of the stream elements
 * @param <S> the type of of the stream extending {@code AbstractStreamEx}
 * @author Tagir Valeev
 */
public abstract class AbstractStreamEx<T, S extends AbstractStreamEx<T, S>> extends
        BaseStreamEx<T, Stream<T>, Spliterator<T>, S> implements Stream<T>, Iterable<T> {
    @SuppressWarnings("unchecked")
    AbstractStreamEx(Stream<? extends T> stream, StreamContext context) {
        super((Stream<T>) stream, context);
    }

    @SuppressWarnings("unchecked")
    AbstractStreamEx(Spliterator<? extends T> spliterator, StreamContext context) {
        super((Spliterator<T>) spliterator, context);
    }

    @Override
    final Stream<T> createStream() {
        return StreamSupport.stream(spliterator, context.parallel);
    }

    final <K, V, M extends Map<K, V>> M toMapThrowing(Function<? super T, ? extends K> keyMapper,
                                                      Function<? super T, ? extends V> valMapper, M map) {
        forEach(t -> addToMap(map, keyMapper.apply(t), Objects.requireNonNull(valMapper.apply(t))));
        return map;
    }

    static <K, V, M extends Map<K, V>> void addToMap(M map, K key, V val) {
        V oldVal = map.putIfAbsent(key, val);
        if (oldVal != null) {
            throw new IllegalStateException("Duplicate entry for key '" + key + "' (attempt to merge values '" + oldVal
                    + "' and '" + val + "')");
        }
    }

    <R, A> R rawCollect(Collector<? super T, A, R> collector) {
        if (context.fjp != null)
            return context.terminate(collector, stream()::collect);
        return stream().collect(collector);
    }

    @SuppressWarnings("unchecked")
    S appendSpliterator(Stream<? extends T> other, Spliterator<? extends T> right) {
        if (right.getExactSizeIfKnown() == 0)
            return (S) this;
        Spliterator<T> left = spliterator();
        Spliterator<T> result;
        if (left.getExactSizeIfKnown() == 0)
            result = (Spliterator<T>) right;
        else
            result = new TailConcatSpliterator<>(left, right);
        context = context.combine(other);
        return supply(result);
    }

    @SuppressWarnings("unchecked")
    S prependSpliterator(Stream<? extends T> other, Spliterator<? extends T> left) {
        if (left.getExactSizeIfKnown() == 0)
            return (S) this;
        Spliterator<T> right = spliterator();
        Spliterator<T> result;
        if (right.getExactSizeIfKnown() == 0)
            result = (Spliterator<T>) left;
        else
            result = new TailConcatSpliterator<>(left, right);
        context = context.combine(other);
        return supply(result);
    }

    @SuppressWarnings("unchecked")
    S ifEmpty(Stream<? extends T> other, Spliterator<? extends T> right) {
        if (right.getExactSizeIfKnown() == 0)
            return (S) this;
        Spliterator<T> left = spliterator();
        Spliterator<T> result;
        if (left.getExactSizeIfKnown() == 0)
            result = (Spliterator<T>) right;
        else
            result = new IfEmptySpliterator<>(left, right);
        context = context.combine(other);
        return supply(result);
    }

    abstract S supply(Stream<T> stream);

    abstract S supply(Spliterator<T> spliterator);

    @Override
    public Iterator<T> iterator() {
        return Spliterators.iterator(spliterator());
    }

    @SuppressWarnings("unchecked")
    @Override
    public S sequential() {
        return (S) super.sequential();
    }

    @SuppressWarnings("unchecked")
    @Override
    public S parallel() {
        return (S) super.parallel();
    }

    @Override
    @SuppressWarnings("unchecked")
    public S parallel(ForkJoinPool fjp) {
        return (S) super.parallel(fjp);
    }

    @SuppressWarnings("unchecked")
    @Override
    public S unordered() {
        return (S) super.unordered();
    }

    @SuppressWarnings("unchecked")
    @Override
    public S onClose(Runnable closeHandler) {
        return (S) super.onClose(closeHandler);
    }

    /**
     * @see #nonNull()
     * @see #remove(Predicate)
     * @see StreamEx#select(Class)
     */
    @Override
    public S filter(Predicate<? super T> predicate) {
        return supply(stream().filter(predicate));
    }

    @Override
    public <R> StreamEx<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper) {
        return new StreamEx<>(stream().flatMap(mapper), context);
    }

    @Override
    public <R> StreamEx<R> map(Function<? super T, ? extends R> mapper) {
        return new StreamEx<>(stream().map(mapper), context);
    }

    @Override
    public IntStreamEx mapToInt(ToIntFunction<? super T> mapper) {
        return new IntStreamEx(stream().mapToInt(mapper), context);
    }

    @Override
    public LongStreamEx mapToLong(ToLongFunction<? super T> mapper) {
        return new LongStreamEx(stream().mapToLong(mapper), context);
    }

    @Override
    public DoubleStreamEx mapToDouble(ToDoubleFunction<? super T> mapper) {
        return new DoubleStreamEx(stream().mapToDouble(mapper), context);
    }

    @Override
    public IntStreamEx flatMapToInt(Function<? super T, ? extends IntStream> mapper) {
        return new IntStreamEx(stream().flatMapToInt(mapper), context);
    }

    @Override
    public LongStreamEx flatMapToLong(Function<? super T, ? extends LongStream> mapper) {
        return new LongStreamEx(stream().flatMapToLong(mapper), context);
    }

    @Override
    public DoubleStreamEx flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper) {
        return new DoubleStreamEx(stream().flatMapToDouble(mapper), context);
    }

    /**
     * Returns a new stream containing all the elements of the original stream interspersed with
     * given delimiter.
     *
     * <p>
     * For example, {@code StreamEx.of("a", "b", "c").intersperse("x")} will yield a stream containing
     * five elements: a, x, b, x, c.
     *
     * <p>
     * This is an <a href="package-summary.html#StreamOps">intermediate operation</a>.
     *
     * @param delimiter a delimiter to be inserted between each pair of elements
     * @return the new stream
     * @since 0.6.6
     */
    public S intersperse(T delimiter) {
        return supply(stream().flatMap(s -> StreamEx.of(delimiter, s)).skip(1));
    }

    @Override
    public S distinct() {
        return supply(stream().distinct());
    }

    /**
     * Returns a stream consisting of the distinct elements of this stream
     * (according to object equality of the results of applying the given
     * function).
     *
     * <p>
     * For ordered streams, the selection of distinct elements is stable (for
     * duplicated elements, the element appearing first in the encounter order
     * is preserved.) For unordered streams, no stability guarantees are made.
     *
     * <p>
     * This is a <a href="package-summary.html#StreamOps">stateful intermediate
     * operation</a>.
     *
     * @param keyExtractor a non-interfering, stateless function which
     *                     classifies input elements.
     * @return the new stream
     * @since 0.3.8
     */
    public S distinct(Function<? super T, ?> keyExtractor) {
        return supply(stream().map(t -> new Internals.PairBox<>(t, keyExtractor.apply(t))).distinct().map(box -> box.a));
    }

    /**
     * Returns a {@code StreamEx} consisting of the distinct elements (according
     * to {@link Object#equals(Object)}) which appear at least specified number
     * of times in this stream.
     *
     * <p>
     * This operation is not guaranteed to be stable: any of equal elements can
     * be selected for the output. However if this stream is ordered then order
     * is preserved.
     *
     * <p>
     * This is a stateful <a
     * href="package-summary.html#StreamOps">quasi-intermediate</a> operation.
     *
     * @param atLeast minimal number of occurrences required to select the
     *                element. If atLeast is 1 or less, then this method is equivalent
     *                to {@link #distinct()}.
     * @return the new stream
     * @see #distinct()
     * @since 0.3.1
     */
    public S distinct(long atLeast) {
        if (atLeast <= 1)
            return distinct();
        Spliterator<T> spliterator = spliterator();
        Spliterator<T> result;
        if (spliterator.hasCharacteristics(Spliterator.DISTINCT))
            // already distinct: cannot have any repeating elements
            result = Spliterators.emptySpliterator();
        else
            result = new DistinctSpliterator<>(spliterator, atLeast);
        return supply(result);
    }

    @Override
    public S sorted() {
        return supply(stream().sorted());
    }

    @Override
    public S sorted(Comparator<? super T> comparator) {
        return supply(stream().sorted(comparator));
    }

    @Override
    public S peek(Consumer<? super T> action) {
        return supply(stream().peek(action));
    }

    @Override
    public S limit(long maxSize) {
        return supply(stream().limit(maxSize));
    }

    @Override
    public S skip(long n) {
        return supply(stream().skip(n));
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        if (spliterator != null && !isParallel()) {
            spliterator().forEachRemaining(action);
        } else {
            if (context.fjp != null)
                context.terminate(() -> {
                    stream().forEach(action);
                    return null;
                });
            else {
                stream().forEach(action);
            }
        }
    }

    @Override
    public void forEachOrdered(Consumer<? super T> action) {
        if (spliterator != null && !isParallel()) {
            spliterator().forEachRemaining(action);
        } else {
            if (context.fjp != null)
                context.terminate(() -> {
                    stream().forEachOrdered(action);
                    return null;
                });
            else {
                stream().forEachOrdered(action);
            }
        }
    }

    @Override
    public Object[] toArray() {
        return toArray(Object[]::new);
    }

    @Override
    public <A> A[] toArray(IntFunction<A[]> generator) {
        if (context.fjp != null)
            return context.terminate(generator, stream()::toArray);
        return stream().toArray(generator);
    }

    @Override
    public T reduce(T identity, BinaryOperator<T> accumulator) {
        if (context.fjp != null)
            return context.terminate(() -> stream().reduce(identity, accumulator));
        return stream().reduce(identity, accumulator);
    }

    @Override
    public Optional<T> reduce(BinaryOperator<T> accumulator) {
        if (context.fjp != null)
            return context.terminate(accumulator, stream()::reduce);
        return stream().reduce(accumulator);
    }

    @Override
    public <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner) {
        if (context.fjp != null)
            return context.terminate(() -> stream().reduce(identity, accumulator, combiner));
        return stream().reduce(identity, accumulator, combiner);
    }

    /**
     * Performs a possibly short-circuiting reduction of the stream elements using
     * the provided {@code BinaryOperator}. The result is described as an {@code Optional<T>}.
     *
     * <p>
     * This is a short-circuiting terminal operation. It behaves like {@link #reduce(BinaryOperator)}. However,
     * it additionally accepts a zero element (also known as absorbing element). When zero element
     * is passed to the accumulator then the result must be zero as well. So the operation
     * takes the advantage of this and may short-circuit if zero is reached during the reduction.
     *
     * @param zero        zero element
     * @param accumulator an <a href="package-summary.html#Associativity">associative</a>
     *                    , <a href="package-summary.html#NonInterference">non-interfering
     *                    </a>, <a href="package-summary.html#Statelessness">stateless</a>
     *                    function to combine two elements into one.
     * @return the result of reduction. Empty Optional is returned if the input stream is empty.
     * @throws NullPointerException if accumulator is null or the result of reduction is null
     * @see MoreCollectors#reducingWithZero(Object, BinaryOperator)
     * @see #reduceWithZero(Object, Object, BinaryOperator)
     * @see #reduce(BinaryOperator)
     * @since 0.7.3
     */
    public Optional<T> reduceWithZero(T zero, BinaryOperator<T> accumulator) {
        return collect(MoreCollectors.reducingWithZero(zero, accumulator));
    }

    /**
     * Performs a possibly short-circuiting reduction of the stream elements using
     * the provided identity value and a {@code BinaryOperator}.
     *
     * <p>
     * This is a short-circuiting terminal operation. It behaves like {@link #reduce(Object, BinaryOperator)}.
     * However, it additionally accepts a zero element (also known as absorbing element). When zero element
     * is passed to the accumulator then the result must be zero as well. So the operation
     * takes the advantage of this and may short-circuit if zero is reached during the reduction.
     *
     * @param zero        zero element
     * @param identity    an identity element. For all {@code t}, {@code accumulator.apply(t, identity)} is
     *                    equal to {@code accumulator.apply(identity, t)} and is equal to {@code t}.
     * @param accumulator an <a href="package-summary.html#Associativity">associative</a>
     *                    , <a href="package-summary.html#NonInterference">non-interfering
     *                    </a>, <a href="package-summary.html#Statelessness">stateless</a>
     *                    function to combine two elements into one.
     * @return the result of reduction. Empty Optional is returned if the input stream is empty.
     * @throws NullPointerException if accumulator is null or the result of reduction is null
     * @see MoreCollectors#reducingWithZero(Object, Object, BinaryOperator)
     * @see #reduceWithZero(Object, BinaryOperator)
     * @see #reduce(Object, BinaryOperator)
     * @since 0.7.3
     */
    public T reduceWithZero(T zero, T identity, BinaryOperator<T> accumulator) {
        return collect(MoreCollectors.reducingWithZero(zero, identity, accumulator));
    }

    @Override
    public <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner) {
        if (context.fjp != null)
            return context.terminate(() -> stream().collect(supplier, accumulator, combiner));
        return stream().collect(supplier, accumulator, combiner);
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * If special <a
     * href="package-summary.html#ShortCircuitReduction">short-circuiting
     * collector</a> is passed, this operation becomes short-circuiting as well.
     */
    @Override
    public <R, A> R collect(Collector<? super T, A, R> collector) {
        Predicate<A> finished = finished(collector);
        if (finished != null) {
            BiConsumer<A, ? super T> acc = collector.accumulator();
            BinaryOperator<A> combiner = collector.combiner();
            Spliterator<T> spliterator = spliterator();
            if (!isParallel()) {
                A a = collector.supplier().get();
                if (!finished.test(a)) {
                    try {
                        // forEachRemaining can be much faster
                        // and take much less memory than tryAdvance for certain
                        // spliterators
                        spliterator.forEachRemaining(e -> {
                            acc.accept(a, e);
                            if (finished.test(a))
                                throw new CancelException();
                        });
                    } catch (CancelException ex) {
                        // ignore
                    }
                }
                return collector.finisher().apply(a);
            }
            Spliterator<A> spltr;
            if (!spliterator.hasCharacteristics(Spliterator.ORDERED)
                    || collector.characteristics().contains(Characteristics.UNORDERED)) {
                spltr = new UnorderedCancellableSpliterator<>(spliterator, collector.supplier(), acc, combiner,
                        finished);
            } else {
                spltr = new OrderedCancellableSpliterator<>(spliterator, collector.supplier(), acc, combiner, finished);
            }
            return collector.finisher().apply(
                    new StreamEx<>(StreamSupport.stream(spltr, true), context).findFirst().get());
        }
        return rawCollect(collector);
    }

    @Override
    public Optional<T> min(Comparator<? super T> comparator) {
        return reduce(BinaryOperator.minBy(comparator));
    }

    @Override
    public Optional<T> max(Comparator<? super T> comparator) {
        return reduce(BinaryOperator.maxBy(comparator));
    }

    @Override
    public long count() {
        if (context.fjp != null)
            return context.terminate(stream()::count);
        return stream().count();
    }

    @Override
    public boolean anyMatch(Predicate<? super T> predicate) {
        if (context.fjp != null)
            return context.terminate(predicate, stream()::anyMatch);
        return stream().anyMatch(predicate);
    }

    @Override
    public boolean allMatch(Predicate<? super T> predicate) {
        if (context.fjp != null)
            return context.terminate(predicate, stream()::allMatch);
        return stream().allMatch(predicate);
    }

    @Override
    public boolean noneMatch(Predicate<? super T> predicate) {
        return !anyMatch(predicate);
    }

    @Override
    public Optional<T> findFirst() {
        if (context.fjp != null)
            return context.terminate(stream()::findFirst);
        return stream().findFirst();
    }

    @Override
    public Optional<T> findAny() {
        if (context.fjp != null)
            return context.terminate(stream()::findAny);
        return stream().findAny();
    }

    /**
     * Returns an {@link OptionalLong} describing the zero-based index of the
     * first element of this stream, which equals to the given element, or an
     * empty {@code OptionalLong} if there's no matching element.
     *
     * <p>
     * This is a short-circuiting terminal operation.
     *
     * @param element an element to look for
     * @return an {@code OptionalLong} describing the index of the first
     * matching element of this stream, or an empty {@code OptionalLong}
     * if there's no matching element.
     * @see #indexOf(Predicate)
     * @since 0.4.0
     */
    public OptionalLong indexOf(T element) {
        return indexOf(Predicate.isEqual(element));
    }

    /**
     * Returns an {@link OptionalLong} describing the zero-based index of the
     * first element of this stream, which matches given predicate, or an empty
     * {@code OptionalLong} if there's no matching element.
     *
     * <p>
     * This is a short-circuiting terminal operation.
     *
     * @param predicate a <a
     *                  href="package-summary.html#NonInterference">non-interfering </a>,
     *                  <a href="package-summary.html#Statelessness">stateless</a>
     *                  predicate which returned value should match
     * @return an {@code OptionalLong} describing the index of the first
     * matching element of this stream, or an empty {@code OptionalLong}
     * if there's no matching element.
     * @see #findFirst(Predicate)
     * @see #indexOf(Object)
     * @since 0.4.0
     */
    public OptionalLong indexOf(Predicate<? super T> predicate) {
        return collect(new CancellableCollectorImpl<>(() -> new long[]{-1}, (acc, t) -> {
            if (acc[0] < 0) {
                if (predicate.test(t)) {
                    acc[0] = -acc[0] - 1;
                } else {
                    acc[0]--;
                }
            }
        }, (acc1, acc2) -> {
            if (acc1[0] < 0) {
                if (acc2[0] < 0) {
                    acc1[0] = acc1[0] + acc2[0] + 1;
                } else {
                    acc1[0] = acc2[0] - acc1[0] - 1;
                }
            }
            return acc1;
        }, acc -> acc[0] < 0 ? OptionalLong.empty() : OptionalLong.of(acc[0]), acc -> acc[0] >= 0, NO_CHARACTERISTICS));
    }

    /**
     * Returns a stream consisting of the results of replacing each element of
     * this stream with the contents of a mapped collection produced by applying
     * the provided mapping function to each element. (If a mapped collection is
     * {@code null} nothing is added for given element to the resulting stream.)
     *
     * <p>
     * This is an <a href="package-summary.html#StreamOps">intermediate
     * operation</a>.
     *
     * <p>
     * The {@code flatCollection()} operation has the effect of applying a
     * one-to-many transformation to the elements of the stream, and then
     * flattening the resulting elements into a new stream.
     *
     * @param <R>    The element type of the new stream
     * @param mapper a <a
     *               href="package-summary.html#NonInterference">non-interfering </a>,
     *               <a href="package-summary.html#Statelessness">stateless</a>
     *               function to apply to each element which produces a
     *               {@link Collection} of new values
     * @return the new stream
     */
    public <R> StreamEx<R> flatCollection(Function<? super T, ? extends Collection<? extends R>> mapper) {
        return flatMap(t -> {
            Collection<? extends R> c = mapper.apply(t);
            return c == null ? null : StreamEx.of(c.spliterator());
        });
    }

    /**
     * Returns a stream consisting of the results of replacing each element of
     * this stream with the contents of a mapped array produced by applying
     * the provided mapping function to each element. (If a mapped array is
     * {@code null} nothing is added for given element to the resulting stream.)
     *
     * <p>
     * This is an <a href="package-summary.html#StreamOps">intermediate
     * operation</a>.
     *
     * <p>
     * The {@code flatArray()} operation has the effect of applying a
     * one-to-many transformation to the elements of the stream, and then
     * flattening the resulting elements into a new stream.
     *
     * @param <R>    The element type of the new stream
     * @param mapper a <a
     *               href="package-summary.html#NonInterference">non-interfering </a>,
     *               <a href="package-summary.html#Statelessness">stateless</a>
     *               function to apply to each element which produces an
     *               array of new values
     * @return the new stream
     * @since 0.6.5
     */
    public <R> StreamEx<R> flatArray(Function<? super T, ? extends R[]> mapper) {
        return flatMap(t -> {
            R[] a = mapper.apply(t);
            return a == null ? null : StreamEx.of(Arrays.spliterator(a));
        });
    }

    /**
     * Performs a mapping of the stream content to a partial function
     * removing the elements to which the function is not applicable.
     *
     * <p>
     * If the mapping function returns {@link Optional#empty()}, the original
     * value will be removed from the resulting stream. The mapping function
     * may not return null.
     *
     * <p>
     * This is an <a href="package-summary.html#StreamOps">intermediate
     * operation</a>.
     *
     * <p>
     * The {@code mapPartial()} operation has the effect of applying a
     * one-to-zero-or-one transformation to the elements of the stream, and then
     * flattening the resulting elements into a new stream.
     *
     * @param <R>    The element type of the new stream
     * @param mapper a <a
     *               href="package-summary.html#NonInterference">non-interfering </a>,
     *               <a href="package-summary.html#Statelessness">stateless</a>
     *               partial function to apply to each element which returns a present optional
     *               if it's applicable, or an empty optional otherwise
     * @return the new stream
     * @since 0.6.8
     */
    public <R> StreamEx<R> mapPartial(Function<? super T, ? extends Optional<? extends R>> mapper) {
        return new StreamEx<>(stream().map(value -> mapper.apply(value).orElse(null)).filter(Objects::nonNull),
                context);
    }

    /**
     * Returns a stream consisting of the results of applying the given function
     * to the every adjacent pair of elements of this stream.
     *
     * <p>
     * This is a <a href="package-summary.html#StreamOps">quasi-intermediate</a>
     * operation.
     *
     * <p>
     * The output stream will contain one element less than this stream. If this
     * stream contains zero or one element the output stream will be empty.
     *
     * @param <R>    The element type of the new stream
     * @param mapper a non-interfering, stateless function to apply to each
     *               adjacent pair of this stream elements.
     * @return the new stream
     * @since 0.2.1
     */
    public <R> StreamEx<R> pairMap(BiFunction<? super T, ? super T, ? extends R> mapper) {
        PairSpliterator.PSOfRef<T, R> spliterator = new PairSpliterator.PSOfRef<>(mapper, spliterator());
        return new StreamEx<>(spliterator, context);
    }

    /**
     * Returns a stream consisting of the elements of this stream that don't
     * match the given predicate.
     *
     * <p>
     * This is an <a href="package-summary.html#StreamOps">intermediate
     * operation</a>.
     *
     * @param predicate a <a
     *                  href="package-summary.html#NonInterference">non-interfering </a>,
     *                  <a href="package-summary.html#Statelessness">stateless</a>
     *                  predicate to apply to each element to determine if it should be
     *                  excluded
     * @return the new stream
     * @see #filter(Predicate)
     * @see #nonNull()
     * @see StreamEx#select(Class)
     */
    public S remove(Predicate<? super T> predicate) {
        return filter(predicate.negate());
    }

    /**
     * Returns a stream consisting of the elements of this stream that aren't
     * null.
     *
     * <p>
     * This is an <a href="package-summary.html#StreamOps">intermediate
     * operation</a>.
     *
     * @return the new stream
     * @see #filter(Predicate)
     * @see #remove(Predicate)
     * @see StreamEx#select(Class)
     */
    public S nonNull() {
        return filter(Objects::nonNull);
    }

    /**
     * Returns an {@link Optional} describing some element of the stream, which
     * matches given predicate, or an empty {@code Optional} if there's no
     * matching element.
     *
     * <p>
     * This is a short-circuiting terminal operation.
     *
     * <p>
     * The behavior of this operation is explicitly nondeterministic; it is free
     * to select any element in the stream. This is to allow for maximal
     * performance in parallel operations; the cost is that multiple invocations
     * on the same source may not return the same result. (If a stable result is
     * desired, use {@link #findFirst(Predicate)} instead.)
     *
     * @param predicate a <a
     *                  href="package-summary.html#NonInterference">non-interfering </a>,
     *                  <a href="package-summary.html#Statelessness">stateless</a>
     *                  predicate which returned value should match
     * @return an {@code Optional} describing some matching element of this
     * stream, or an empty {@code Optional} if there's no matching
     * element
     * @throws NullPointerException if the element selected is null
     * @see #findAny()
     * @see #findFirst(Predicate)
     */
    public Optional<T> findAny(Predicate<? super T> predicate) {
        return filter(predicate).findAny();
    }

    /**
     * Returns an {@link Optional} describing the first element of this stream,
     * which matches given predicate, or an empty {@code Optional} if there's no
     * matching element.
     *
     * <p>
     * This is a short-circuiting terminal operation.
     *
     * @param predicate a <a
     *                  href="package-summary.html#NonInterference">non-interfering </a>,
     *                  <a href="package-summary.html#Statelessness">stateless</a>
     *                  predicate which returned value should match
     * @return an {@code Optional} describing the first matching element of this
     * stream, or an empty {@code Optional} if there's no matching
     * element
     * @throws NullPointerException if the element selected is null
     * @see #findFirst()
     */
    public Optional<T> findFirst(Predicate<? super T> predicate) {
        return filter(predicate).findFirst();
    }

    /**
     * Returns a stream consisting of the elements of this stream, sorted in
     * descending order according to the provided {@code Comparator}.
     *
     * <p>
     * For ordered streams, the sort is stable. For unordered streams, no
     * stability guarantees are made.
     *
     * <p>
     * This is a <a href="package-summary.html#StreamOps">stateful intermediate
     * operation</a>.
     *
     * @param comparator a <a
     *                   href="package-summary.html#NonInterference">non-interfering </a>,
     *                   <a href="package-summary.html#Statelessness">stateless</a>
     *                   {@code Comparator} to be used to compare stream elements
     * @return the new stream
     */
    public S reverseSorted(Comparator<? super T> comparator) {
        return sorted(comparator.reversed());
    }

    /**
     * Returns a stream consisting of the elements of this stream, sorted
     * according to the natural order of the keys extracted by provided
     * function.
     *
     * <p>
     * For ordered streams, the sort is stable. For unordered streams, no
     * stability guarantees are made.
     *
     * <p>
     * This is a <a href="package-summary.html#StreamOps">stateful intermediate
     * operation</a>.
     *
     * @param <V>          the type of the {@code Comparable} sort key
     * @param keyExtractor a <a
     *                     href="package-summary.html#NonInterference">non-interfering </a>,
     *                     <a href="package-summary.html#Statelessness">stateless</a>
     *                     function to be used to extract sorting keys
     * @return the new stream
     */
    public <V extends Comparable<? super V>> S sortedBy(Function<? super T, ? extends V> keyExtractor) {
        return sorted(Comparator.comparing(keyExtractor));
    }

    /**
     * Returns a stream consisting of the elements of this stream, sorted
     * according to the int values extracted by provided function.
     *
     * <p>
     * For ordered streams, the sort is stable. For unordered streams, no
     * stability guarantees are made.
     *
     * <p>
     * This is a <a href="package-summary.html#StreamOps">stateful intermediate
     * operation</a>.
     *
     * @param keyExtractor a <a
     *                     href="package-summary.html#NonInterference">non-interfering </a>,
     *                     <a href="package-summary.html#Statelessness">stateless</a>
     *                     function to be used to extract sorting keys
     * @return the new stream
     */
    public S sortedByInt(ToIntFunction<? super T> keyExtractor) {
        return sorted(Comparator.comparingInt(keyExtractor));
    }

    /**
     * Returns a stream consisting of the elements of this stream, sorted
     * according to the long values extracted by provided function.
     *
     * <p>
     * For ordered streams, the sort is stable. For unordered streams, no
     * stability guarantees are made.
     *
     * <p>
     * This is a <a href="package-summary.html#StreamOps">stateful intermediate
     * operation</a>.
     *
     * @param keyExtractor a <a
     *                     href="package-summary.html#NonInterference">non-interfering </a>,
     *                     <a href="package-summary.html#Statelessness">stateless</a>
     *                     function to be used to extract sorting keys
     * @return the new stream
     */
    public S sortedByLong(ToLongFunction<? super T> keyExtractor) {
        return sorted(Comparator.comparingLong(keyExtractor));
    }

    /**
     * Returns a stream consisting of the elements of this stream, sorted
     * according to the double values extracted by provided function.
     *
     * <p>
     * For ordered streams, the sort is stable. For unordered streams, no
     * stability guarantees are made.
     *
     * <p>
     * This is a <a href="package-summary.html#StreamOps">stateful intermediate
     * operation</a>.
     *
     * @param keyExtractor a <a
     *                     href="package-summary.html#NonInterference">non-interfering </a>,
     *                     <a href="package-summary.html#Statelessness">stateless</a>
     *                     function to be used to extract sorting keys
     * @return the new stream
     */
    public S sortedByDouble(ToDoubleFunction<? super T> keyExtractor) {
        return sorted(Comparator.comparingDouble(keyExtractor));
    }

    /**
     * Returns the minimum element of this stream according to the natural order
     * of the keys extracted by provided function. This is a special case of a
     * reduction.
     *
     * <p>
     * This is a terminal operation.
     *
     * <p>
     * This method is equivalent to
     * {@code min(Comparator.comparing(keyExtractor))}, but may work faster as
     * keyExtractor function is applied only once per each input element.
     *
     * @param <V>          the type of the comparable keys
     * @param keyExtractor a <a
     *                     href="package-summary.html#NonInterference">non-interfering </a>,
     *                     <a href="package-summary.html#Statelessness">stateless</a>
     *                     function to extract the comparable keys from this stream elements
     * @return an {@code Optional} describing the minimum element of this
     * stream, or an empty {@code Optional} if the stream is empty
     * @throws NullPointerException if the minimum element is null
     */
    public <V extends Comparable<? super V>> Optional<T> minBy(Function<? super T, ? extends V> keyExtractor) {
        return Box
                .asOptional(reduce(null, (PairBox<T, V> acc, T t) -> {
                    V val = keyExtractor.apply(t);
                    if (acc == null)
                        return new PairBox<>(t, val);
                    if (val.compareTo(acc.b) < 0) {
                        acc.b = val;
                        acc.a = t;
                    }
                    return acc;
                }, (PairBox<T, V> acc1, PairBox<T, V> acc2) -> (acc1 == null || acc2 != null
                        && acc1.b.compareTo(acc2.b) > 0) ? acc2 : acc1));
    }

    /**
     * Returns the minimum element of this stream according to the int values
     * extracted by provided function. This is a special case of a reduction.
     *
     * <p>
     * This is a terminal operation.
     *
     * <p>
     * This method is equivalent to
     * {@code min(Comparator.comparingInt(keyExtractor))}, but may work faster
     * as keyExtractor function is applied only once per each input element.
     *
     * @param keyExtractor a <a
     *                     href="package-summary.html#NonInterference">non-interfering </a>,
     *                     <a href="package-summary.html#Statelessness">stateless</a>
     *                     function to extract the int keys from this stream elements
     * @return an {@code Optional} describing the minimum element of this
     * stream, or an empty {@code Optional} if the stream is empty
     * @throws NullPointerException if the minimum element is null
     */
    public Optional<T> minByInt(ToIntFunction<? super T> keyExtractor) {
        return Box.asOptional(reduce(null, (ObjIntBox<T> acc, T t) -> {
            int val = keyExtractor.applyAsInt(t);
            if (acc == null)
                return new ObjIntBox<>(t, val);
            if (val < acc.b) {
                acc.b = val;
                acc.a = t;
            }
            return acc;
        }, (ObjIntBox<T> acc1, ObjIntBox<T> acc2) -> (acc1 == null || acc2 != null && acc1.b > acc2.b) ? acc2 : acc1));
    }

    /**
     * Returns the minimum element of this stream according to the long values
     * extracted by provided function. This is a special case of a reduction.
     *
     * <p>
     * This is a terminal operation.
     *
     * <p>
     * This method is equivalent to
     * {@code min(Comparator.comparingLong(keyExtractor))}, but may work faster
     * as keyExtractor function is applied only once per each input element.
     *
     * @param keyExtractor a <a
     *                     href="package-summary.html#NonInterference">non-interfering </a>,
     *                     <a href="package-summary.html#Statelessness">stateless</a>
     *                     function to extract the long keys from this stream elements
     * @return an {@code Optional} describing the minimum element of this
     * stream, or an empty {@code Optional} if the stream is empty
     * @throws NullPointerException if the minimum element is null
     */
    public Optional<T> minByLong(ToLongFunction<? super T> keyExtractor) {
        return Box
                .asOptional(reduce(null, (ObjLongBox<T> acc, T t) -> {
                    long val = keyExtractor.applyAsLong(t);
                    if (acc == null)
                        return new ObjLongBox<>(t, val);
                    if (val < acc.b) {
                        acc.b = val;
                        acc.a = t;
                    }
                    return acc;
                }, (ObjLongBox<T> acc1, ObjLongBox<T> acc2) -> (acc1 == null || acc2 != null && acc1.b > acc2.b) ? acc2
                        : acc1));
    }

    /**
     * Returns the minimum element of this stream according to the double values
     * extracted by provided function. This is a special case of a reduction.
     *
     * <p>
     * This is a terminal operation.
     *
     * <p>
     * This method is equivalent to
     * {@code min(Comparator.comparingDouble(keyExtractor))}, but may work
     * faster as keyExtractor function is applied only once per each input
     * element.
     *
     * @param keyExtractor a <a
     *                     href="package-summary.html#NonInterference">non-interfering </a>,
     *                     <a href="package-summary.html#Statelessness">stateless</a>
     *                     function to extract the double keys from this stream elements
     * @return an {@code Optional} describing the minimum element of this
     * stream, or an empty {@code Optional} if the stream is empty
     * @throws NullPointerException if the minimum element is null
     */
    public Optional<T> minByDouble(ToDoubleFunction<? super T> keyExtractor) {
        return Box.asOptional(reduce(null, (ObjDoubleBox<T> acc, T t) -> {
            double val = keyExtractor.applyAsDouble(t);
            if (acc == null)
                return new ObjDoubleBox<>(t, val);
            if (Double.compare(val, acc.b) < 0) {
                acc.b = val;
                acc.a = t;
            }
            return acc;
        }, (ObjDoubleBox<T> acc1, ObjDoubleBox<T> acc2) -> (acc1 == null || acc2 != null
                && Double.compare(acc1.b, acc2.b) > 0) ? acc2 : acc1));
    }

    /**
     * Returns the maximum element of this stream according to the natural order
     * of the keys extracted by provided function. This is a special case of a
     * reduction.
     *
     * <p>
     * This is a terminal operation.
     *
     * <p>
     * This method is equivalent to
     * {@code max(Comparator.comparing(keyExtractor))}, but may work faster as
     * keyExtractor function is applied only once per each input element.
     *
     * @param <V>          the type of the comparable keys
     * @param keyExtractor a <a
     *                     href="package-summary.html#NonInterference">non-interfering </a>,
     *                     <a href="package-summary.html#Statelessness">stateless</a>
     *                     function to extract the comparable keys from this stream elements
     * @return an {@code Optional} describing the maximum element of this
     * stream, or an empty {@code Optional} if the stream is empty
     * @throws NullPointerException if the maximum element is null
     */
    public <V extends Comparable<? super V>> Optional<T> maxBy(Function<? super T, ? extends V> keyExtractor) {
        return Box
                .asOptional(reduce(null, (PairBox<T, V> acc, T t) -> {
                    V val = keyExtractor.apply(t);
                    if (acc == null)
                        return new PairBox<>(t, val);
                    if (val.compareTo(acc.b) > 0) {
                        acc.b = val;
                        acc.a = t;
                    }
                    return acc;
                }, (PairBox<T, V> acc1, PairBox<T, V> acc2) -> (acc1 == null || acc2 != null
                        && acc1.b.compareTo(acc2.b) < 0) ? acc2 : acc1));
    }

    /**
     * Returns the maximum element of this stream according to the int values
     * extracted by provided function. This is a special case of a reduction.
     *
     * <p>
     * This is a terminal operation.
     *
     * <p>
     * This method is equivalent to
     * {@code max(Comparator.comparingInt(keyExtractor))}, but may work faster
     * as keyExtractor function is applied only once per each input element.
     *
     * @param keyExtractor a <a
     *                     href="package-summary.html#NonInterference">non-interfering </a>,
     *                     <a href="package-summary.html#Statelessness">stateless</a>
     *                     function to extract the int keys from this stream elements
     * @return an {@code Optional} describing the maximum element of this
     * stream, or an empty {@code Optional} if the stream is empty
     * @throws NullPointerException if the maximum element is null
     */
    public Optional<T> maxByInt(ToIntFunction<? super T> keyExtractor) {
        return Box.asOptional(reduce(null, (ObjIntBox<T> acc, T t) -> {
            int val = keyExtractor.applyAsInt(t);
            if (acc == null)
                return new ObjIntBox<>(t, val);
            if (val > acc.b) {
                acc.b = val;
                acc.a = t;
            }
            return acc;
        }, (ObjIntBox<T> acc1, ObjIntBox<T> acc2) -> (acc1 == null || acc2 != null && acc1.b < acc2.b) ? acc2 : acc1));
    }

    /**
     * Returns the maximum element of this stream according to the long values
     * extracted by provided function. This is a special case of a reduction.
     *
     * <p>
     * This is a terminal operation.
     *
     * <p>
     * This method is equivalent to
     * {@code max(Comparator.comparingLong(keyExtractor))}, but may work faster
     * as keyExtractor function is applied only once per each input element.
     *
     * @param keyExtractor a <a
     *                     href="package-summary.html#NonInterference">non-interfering </a>,
     *                     <a href="package-summary.html#Statelessness">stateless</a>
     *                     function to extract the long keys from this stream elements
     * @return an {@code Optional} describing the maximum element of this
     * stream, or an empty {@code Optional} if the stream is empty
     * @throws NullPointerException if the maximum element is null
     */
    public Optional<T> maxByLong(ToLongFunction<? super T> keyExtractor) {
        return Box
                .asOptional(reduce(null, (ObjLongBox<T> acc, T t) -> {
                    long val = keyExtractor.applyAsLong(t);
                    if (acc == null)
                        return new ObjLongBox<>(t, val);
                    if (val > acc.b) {
                        acc.b = val;
                        acc.a = t;
                    }
                    return acc;
                }, (ObjLongBox<T> acc1, ObjLongBox<T> acc2) -> (acc1 == null || acc2 != null && acc1.b < acc2.b) ? acc2
                        : acc1));
    }

    /**
     * Returns the maximum element of this stream according to the double values
     * extracted by provided function. This is a special case of a reduction.
     *
     * <p>
     * This is a terminal operation.
     *
     * <p>
     * This method is equivalent to
     * {@code max(Comparator.comparingDouble(keyExtractor))}, but may work
     * faster as keyExtractor function is applied only once per each input
     * element.
     *
     * @param keyExtractor a <a
     *                     href="package-summary.html#NonInterference">non-interfering </a>,
     *                     <a href="package-summary.html#Statelessness">stateless</a>
     *                     function to extract the double keys from this stream elements
     * @return an {@code Optional} describing the maximum element of this
     * stream, or an empty {@code Optional} if the stream is empty
     * @throws NullPointerException if the maximum element is null
     */
    public Optional<T> maxByDouble(ToDoubleFunction<? super T> keyExtractor) {
        return Box.asOptional(reduce(null, (ObjDoubleBox<T> acc, T t) -> {
            double val = keyExtractor.applyAsDouble(t);
            if (acc == null)
                return new ObjDoubleBox<>(t, val);
            if (Double.compare(val, acc.b) > 0) {
                acc.b = val;
                acc.a = t;
            }
            return acc;
        }, (ObjDoubleBox<T> acc1, ObjDoubleBox<T> acc2) -> (acc1 == null || acc2 != null
                && Double.compare(acc1.b, acc2.b) < 0) ? acc2 : acc1));
    }

    /**
     * Creates a lazily concatenated stream whose elements are all the elements
     * of this stream followed by all the elements of the other stream. The
     * resulting stream is ordered if both of the input streams are ordered, and
     * parallel if either of the input streams is parallel. When the resulting
     * stream is closed, the close handlers for both input streams are invoked.
     *
     * <p>
     * This is a <a href="package-summary.html#StreamOps">quasi-intermediate
     * operation</a> with <a href="package-summary.html#TSO">tail-stream
     * optimization</a>.
     *
     * <p>
     * May return this if the supplied stream is known to be empty.
     *
     * @param other the other stream
     * @return this stream appended by the other stream
     * @see Stream#concat(Stream, Stream)
     */
    public S append(Stream<? extends T> other) {
        return appendSpliterator(other, other.spliterator());
    }

    /**
     * Creates a lazily concatenated stream whose elements are all the elements
     * of the other stream followed by all the elements of this stream. The
     * resulting stream is ordered if both of the input streams are ordered, and
     * parallel if either of the input streams is parallel. When the resulting
     * stream is closed, the close handlers for both input streams are invoked.
     *
     * <p>
     * This is a <a href="package-summary.html#StreamOps">quasi-intermediate
     * operation</a> with <a href="package-summary.html#TSO">tail-stream
     * optimization</a>.
     *
     * <p>
     * May return this if the supplied stream is known to be empty.
     *
     * @param other the other stream
     * @return this stream prepended by the other stream
     * @see Stream#concat(Stream, Stream)
     */
    public S prepend(Stream<? extends T> other) {
        return prependSpliterator(other, other.spliterator());
    }

    /**
     * Returns a stream which contents is the same as this stream, except the case when
     * this stream is empty. In this case, its contents is replaced with other stream contents.
     *
     * <p>
     * The other stream will not be traversed if this stream is not empty.
     *
     * <p>
     * If this stream is parallel and empty, the other stream is not guaranteed to be parallelized.
     *
     * <p>
     * This is a <a href="package-summary.html#StreamOps">quasi-intermediate
     * operation</a>.
     *
     * @param other other stream to replace the contents of this stream if this stream is empty.
     * @return the stream which contents is replaced by other stream contents only if this stream is empty.
     * @since 0.6.6
     */
    public S ifEmpty(Stream<? extends T> other) {
        return ifEmpty(other, other.spliterator());
    }

    /**
     * Returns a {@link List} containing the elements of this stream. The
     * returned {@code List} is guaranteed to be mutable, but there are no
     * guarantees on the type, serializability, or thread-safety; if more
     * control over the returned {@code List} is required, use
     * {@link #toCollection(Supplier)}.
     *
     * <p>
     * This is a terminal operation.
     *
     * @return a {@code List} containing the elements of this stream
     * @see Collectors#toList()
     * @see #toImmutableList()
     */
    @SuppressWarnings("unchecked")
    public List<T> toList() {
        return new ArrayList<>((Collection<T>) new ArrayCollection(toArray(Object[]::new)));
    }

    /**
     * Returns an immutable {@link List} containing the elements of this stream.
     * There's no guarantees on exact type of the returned {@code List}. The
     * returned {@code List} is guaranteed to be serializable if all its
     * elements are serializable.
     *
     * <p>
     * This is a terminal operation.
     *
     * @return a {@code List} containing the elements of this stream
     * @see #toList()
     * @since 0.6.3
     */
    @SuppressWarnings("unchecked")
    public List<T> toImmutableList() {
        Object[] array = toArray(Object[]::new);
        switch (array.length) {
            case 0:
                return Collections.emptyList();
            case 1:
                return Collections.singletonList((T) array[0]);
            default:
                return Collections.unmodifiableList(Arrays.asList((T[]) array));
        }
    }

    /**
     * Creates a {@link List} containing the elements of this stream, then
     * performs finishing transformation and returns its result. There are no
     * guarantees on the type, serializability or thread-safety of the
     * {@code List} created.
     *
     * <p>
     * This is a terminal operation.
     *
     * @param <R>      the type of the result
     * @param finisher a function to be applied to the intermediate list
     * @return result of applying the finisher transformation to the list of the
     * stream elements.
     * @see #toList()
     * @since 0.2.3
     */
    public <R> R toListAndThen(Function<? super List<T>, R> finisher) {
        if (context.fjp != null)
            return context.terminate(() -> finisher.apply(toList()));
        return finisher.apply(toList());
    }

    /**
     * Returns a {@link Set} containing the elements of this stream. The
     * returned {@code Set} is guaranteed to be mutable, but there are no
     * guarantees on the type, serializability, or thread-safety; if more
     * control over the returned {@code Set} is required, use
     * {@link #toCollection(Supplier)}.
     *
     * <p>
     * This is a terminal operation.
     *
     * @return a {@code Set} containing the elements of this stream
     * @see Collectors#toSet()
     */
    public Set<T> toSet() {
        return rawCollect(Collectors.toSet());
    }

    /**
     * Returns an immutable {@link Set} containing the elements of this stream.
     * There's no guarantees on exact type of the returned {@code Set}. In
     * particular, no specific element order in the resulting set is guaranteed.
     * The returned {@code Set} is guaranteed to be serializable if all its
     * elements are serializable.
     *
     * <p>
     * This is a terminal operation.
     *
     * @return a {@code Set} containing the elements of this stream
     * @see #toSet()
     * @since 0.6.3
     */
    public Set<T> toImmutableSet() {
        Set<T> result = toSet();
        if (result.size() == 0)
            return Collections.emptySet();
        return Collections.unmodifiableSet(result);
    }

    /**
     * Creates a {@link Set} containing the elements of this stream, then
     * performs finishing transformation and returns its result. There are no
     * guarantees on the type, serializability or thread-safety of the
     * {@code Set} created.
     *
     * <p>
     * This is a terminal operation.
     *
     * @param <R>      the result type
     * @param finisher a function to be applied to the intermediate {@code Set}
     * @return result of applying the finisher transformation to the {@code Set}
     * of the stream elements.
     * @see #toSet()
     * @since 0.2.3
     */
    public <R> R toSetAndThen(Function<? super Set<T>, R> finisher) {
        if (context.fjp != null)
            return context.terminate(() -> finisher.apply(toSet()));
        return finisher.apply(toSet());
    }

    /**
     * Creates a custom {@link Collection} containing the elements of this stream,
     * then performs finishing transformation and returns its result. The
     * {@code Collection} is created by the provided factory.
     *
     * <p>
     * This is a terminal operation.
     *
     * @param <C>               the type of the resulting {@code Collection}
     * @param <R>               the result type
     * @param collectionFactory a {@code Supplier} which returns a new, empty
     *                          {@code Collection} of the appropriate type
     * @param finisher          a function to be applied to the intermediate {@code Collection}
     * @return result of applying the finisher transformation to the {@code Collection}
     * of the stream elements.
     * @see #toCollection(Supplier)
     * @since 0.7.3
     */
    public <C extends Collection<T>, R> R toCollectionAndThen(Supplier<C> collectionFactory,
                                                              Function<? super C, R> finisher) {
        if (context.fjp != null)
            return context.terminate(() -> finisher.apply(toCollection(collectionFactory)));
        return finisher.apply(toCollection(collectionFactory));
    }

    /**
     * Returns a {@link Collection} containing the elements of this stream. The
     * {@code Collection} is created by the provided factory.
     *
     * <p>
     * This is a terminal operation.
     *
     * @param <C>               the type of the resulting {@code Collection}
     * @param collectionFactory a {@code Supplier} which returns a new, empty
     *                          {@code Collection} of the appropriate type
     * @return a {@code Collection} containing the elements of this stream
     * @see Collectors#toCollection(Supplier)
     * @see #toCollectionAndThen(Supplier, Function)
     */
    public <C extends Collection<T>> C toCollection(Supplier<C> collectionFactory) {
        return rawCollect(Collectors.toCollection(collectionFactory));
    }

    /**
     * Folds the elements of this stream using the provided seed object and
     * accumulation function, going left to right. This is equivalent to:
     *
     * <pre>
     * {@code
     *     U result = seed;
     *     for (T element : this stream)
     *         result = accumulator.apply(result, element)
     *     return result;
     * }
     * </pre>
     *
     * <p>
     * This is a terminal operation.
     *
     * <p>
     * This method cannot take all the advantages of parallel streams as it must
     * process elements strictly left to right. If your accumulator function is
     * associative and you can provide a combiner function, consider using
     * {@link #reduce(Object, BiFunction, BinaryOperator)} method.
     *
     * <p>
     * For parallel stream it's not guaranteed that accumulator will always be
     * executed in the same thread.
     *
     * @param <U>         The type of the result
     * @param seed        the starting value
     * @param accumulator a <a
     *                    href="package-summary.html#NonInterference">non-interfering </a>,
     *                    <a href="package-summary.html#Statelessness">stateless</a>
     *                    function for incorporating an additional element into a result
     * @return the result of the folding
     * @see #foldRight(Object, BiFunction)
     * @see #reduce(Object, BinaryOperator)
     * @see #reduce(Object, BiFunction, BinaryOperator)
     * @since 0.2.0
     */
    public <U> U foldLeft(U seed, BiFunction<U, ? super T, U> accumulator) {
        Box<U> result = new Box<>(seed);
        forEachOrdered(t -> result.a = accumulator.apply(result.a, t));
        return result.a;
    }

    /**
     * Folds the elements of this stream using the provided accumulation
     * function, going left to right. This is equivalent to:
     *
     * <pre>
     * {@code
     *     boolean foundAny = false;
     *     T result = null;
     *     for (T element : this stream) {
     *         if (!foundAny) {
     *             foundAny = true;
     *             result = element;
     *         }
     *         else
     *             result = accumulator.apply(result, element);
     *     }
     *     return foundAny ? Optional.of(result) : Optional.empty();
     * }
     * </pre>
     *
     * <p>
     * This is a terminal operation.
     *
     * <p>
     * This method cannot take all the advantages of parallel streams as it must
     * process elements strictly left to right. If your accumulator function is
     * associative, consider using {@link #reduce(BinaryOperator)} method.
     *
     * <p>
     * For parallel stream it's not guaranteed that accumulator will always be
     * executed in the same thread.
     *
     * @param accumulator a <a
     *                    href="package-summary.html#NonInterference">non-interfering </a>,
     *                    <a href="package-summary.html#Statelessness">stateless</a>
     *                    function for incorporating an additional element into a result
     * @return the result of the folding
     * @see #foldLeft(Object, BiFunction)
     * @see #foldRight(BinaryOperator)
     * @see #reduce(BinaryOperator)
     * @since 0.4.0
     */
    public Optional<T> foldLeft(BinaryOperator<T> accumulator) {
        Box<T> result = new Box<>(none());
        forEachOrdered(t -> result.a = result.a == NONE ? t : accumulator.apply(result.a, t));
        return result.a == NONE ? Optional.empty() : Optional.of(result.a);
    }

    /**
     * Folds the elements of this stream using the provided seed object and
     * accumulation function, going right to left.
     *
     * <p>
     * This is a terminal operation.
     *
     * <p>
     * As this method must process elements strictly right to left, it cannot
     * start processing till all the previous stream stages complete. Also it
     * requires intermediate memory to store the whole content of the stream as
     * the stream natural order is left to right. If your accumulator function
     * is associative and you can provide a combiner function, consider using
     * {@link #reduce(Object, BiFunction, BinaryOperator)} method.
     *
     * <p>
     * For parallel stream it's not guaranteed that accumulator will always be
     * executed in the same thread.
     *
     * @param <U>         The type of the result
     * @param seed        the starting value
     * @param accumulator a <a
     *                    href="package-summary.html#NonInterference">non-interfering </a>,
     *                    <a href="package-summary.html#Statelessness">stateless</a>
     *                    function for incorporating an additional element into a result
     * @return the result of the folding
     * @see #foldLeft(Object, BiFunction)
     * @see #reduce(Object, BinaryOperator)
     * @see #reduce(Object, BiFunction, BinaryOperator)
     * @since 0.2.2
     */
    public <U> U foldRight(U seed, BiFunction<? super T, U, U> accumulator) {
        return toListAndThen(list -> {
            U result = seed;
            for (int i = list.size() - 1; i >= 0; i--)
                result = accumulator.apply(list.get(i), result);
            return result;
        });
    }

    /**
     * Folds the elements of this stream using the provided accumulation
     * function, going right to left.
     *
     * <p>
     * This is a terminal operation.
     *
     * <p>
     * As this method must process elements strictly right to left, it cannot
     * start processing till all the previous stream stages complete. Also it
     * requires intermediate memory to store the whole content of the stream as
     * the stream natural order is left to right. If your accumulator function
     * is associative, consider using {@link #reduce(BinaryOperator)} method.
     *
     * <p>
     * For parallel stream it's not guaranteed that accumulator will always be
     * executed in the same thread.
     *
     * @param accumulator a <a
     *                    href="package-summary.html#NonInterference">non-interfering </a>,
     *                    <a href="package-summary.html#Statelessness">stateless</a>
     *                    function for incorporating an additional element into a result
     * @return the result of the folding
     * @see #foldRight(Object, BiFunction)
     * @see #foldLeft(BinaryOperator)
     * @see #reduce(BinaryOperator)
     * @since 0.4.0
     */
    public Optional<T> foldRight(BinaryOperator<T> accumulator) {
        return toListAndThen(list -> {
            if (list.isEmpty())
                return Optional.empty();
            int i = list.size() - 1;
            T result = list.get(i--);
            for (; i >= 0; i--)
                result = accumulator.apply(list.get(i), result);
            return Optional.of(result);
        });
    }

    /**
     * Produces a list containing cumulative results of applying the
     * accumulation function going left to right using given seed value.
     *
     * <p>
     * This is a terminal operation.
     *
     * <p>
     * The resulting {@link List} is guaranteed to be mutable.
     *
     * <p>
     * For parallel stream it's not guaranteed that accumulator will always be
     * executed in the same thread.
     *
     * <p>
     * This method cannot take all the advantages of parallel streams as it must
     * process elements strictly left to right.
     *
     * @param <U>         The type of the result
     * @param seed        the starting value
     * @param accumulator a <a
     *                    href="package-summary.html#NonInterference">non-interfering </a>,
     *                    <a href="package-summary.html#Statelessness">stateless</a>
     *                    function for incorporating an additional element into a result
     * @return the {@code List} where the first element is the seed and every
     * successor element is the result of applying accumulator function
     * to the previous list element and the corresponding stream
     * element. The resulting list is one element longer than this
     * stream.
     * @see #foldLeft(Object, BiFunction)
     * @see #scanRight(Object, BiFunction)
     * @since 0.2.1
     */
    public <U> List<U> scanLeft(U seed, BiFunction<U, ? super T, U> accumulator) {
        List<U> result = new ArrayList<>();
        result.add(seed);
        forEachOrdered(t -> result.add(accumulator.apply(result.get(result.size() - 1), t)));
        return result;
    }

    /**
     * Produces a list containing cumulative results of applying the
     * accumulation function going left to right.
     *
     * <p>
     * This is a terminal operation.
     *
     * <p>
     * The resulting {@link List} is guaranteed to be mutable.
     *
     * <p>
     * For parallel stream it's not guaranteed that accumulator will always be
     * executed in the same thread.
     *
     * <p>
     * This method cannot take all the advantages of parallel streams as it must
     * process elements strictly left to right.
     *
     * @param accumulator a <a
     *                    href="package-summary.html#NonInterference">non-interfering </a>,
     *                    <a href="package-summary.html#Statelessness">stateless</a>
     *                    function for incorporating an additional element into a result
     * @return the {@code List} where the first element is the first element of
     * this stream and every successor element is the result of applying
     * accumulator function to the previous list element and the
     * corresponding stream element. The resulting list has the same
     * size as this stream.
     * @see #foldLeft(BinaryOperator)
     * @see #scanRight(BinaryOperator)
     * @see #prefix(BinaryOperator)
     * @since 0.4.0
     */
    public List<T> scanLeft(BinaryOperator<T> accumulator) {
        List<T> result = new ArrayList<>();
        forEachOrdered(t -> {
            if (result.isEmpty())
                result.add(t);
            else
                result.add(accumulator.apply(result.get(result.size() - 1), t));
        });
        return result;
    }

    /**
     * Produces a list containing cumulative results of applying the
     * accumulation function going right to left using given seed value.
     *
     * <p>
     * This is a terminal operation.
     *
     * <p>
     * The resulting {@link List} is guaranteed to be mutable.
     *
     * <p>
     * For parallel stream it's not guaranteed that accumulator will always be
     * executed in the same thread.
     *
     * <p>
     * This method cannot take all the advantages of parallel streams as it must
     * process elements strictly right to left.
     *
     * @param <U>         The type of the result
     * @param seed        the starting value
     * @param accumulator a <a
     *                    href="package-summary.html#NonInterference">non-interfering </a>,
     *                    <a href="package-summary.html#Statelessness">stateless</a>
     *                    function for incorporating an additional element into a result
     * @return the {@code List} where the last element is the seed and every
     * predecessor element is the result of applying accumulator
     * function to the corresponding stream element and the next list
     * element. The resulting list is one element longer than this
     * stream.
     * @see #scanLeft(Object, BiFunction)
     * @see #foldRight(Object, BiFunction)
     * @since 0.2.2
     */
    @SuppressWarnings("unchecked")
    public <U> List<U> scanRight(U seed, BiFunction<? super T, U, U> accumulator) {
        return toListAndThen(list -> {
            // Reusing the list for different object type as it will save memory
            List<U> result = (List<U>) list;
            result.add(seed);
            for (int i = result.size() - 2; i >= 0; i--) {
                result.set(i, accumulator.apply((T) result.get(i), result.get(i + 1)));
            }
            return result;
        });
    }

    /**
     * Produces a collection containing cumulative results of applying the
     * accumulation function going right to left.
     *
     * <p>
     * This is a terminal operation.
     *
     * <p>
     * The result {@link List} is guaranteed to be mutable.
     *
     * <p>
     * For parallel stream it's not guaranteed that accumulator will always be
     * executed in the same thread.
     *
     * <p>
     * This method cannot take all the advantages of parallel streams as it must
     * process elements strictly right to left.
     *
     * @param accumulator a <a
     *                    href="package-summary.html#NonInterference">non-interfering </a>,
     *                    <a href="package-summary.html#Statelessness">stateless</a>
     *                    function for incorporating an additional element into a result
     * @return the {@code List} where the last element is the last element of
     * this stream and every predecessor element is the result of
     * applying accumulator function to the corresponding stream element
     * and the next list element. The resulting list is one element
     * longer than this stream.
     * @see #scanLeft(BinaryOperator)
     * @see #foldRight(BinaryOperator)
     * @since 0.4.0
     */
    public List<T> scanRight(BinaryOperator<T> accumulator) {
        return toListAndThen(list -> {
            for (int i = list.size() - 2; i >= 0; i--) {
                list.set(i, accumulator.apply(list.get(i), list.get(i + 1)));
            }
            return list;
        });
    }

    /**
     * Returns a stream consisting of all elements from this stream until the
     * first element which does not match the given predicate is found.
     *
     * <p>
     * This is a short-circuiting stateful operation. It can be either <a
     * href="package-summary.html#StreamOps">intermediate or
     * quasi-intermediate</a>. When using with JDK 1.9 or higher it calls the
     * corresponding JDK 1.9 implementation. When using with JDK 1.8 it uses own
     * implementation.
     *
     * <p>
     * While this operation is quite cheap for sequential stream, it can be
     * quite expensive on parallel pipelines. Using unordered source or making it
     * explicitly unordered with {@link #unordered()} call may improve the parallel
     * processing performance if semantics permit.
     *
     * @param predicate a non-interfering, stateless predicate to apply to
     *                  elements.
     * @return the new stream.
     * @see #takeWhileInclusive(Predicate)
     * @see #dropWhile(Predicate)
     * @since 0.3.6
     */
    public S takeWhile(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return VerSpec.VER_SPEC.callWhile(this, predicate, false);
    }

    /**
     * Returns a stream consisting of all elements from this stream until the
     * first element which does not match the given predicates is found
     * (including the first mismatching element).
     *
     * <p>
     * This is a <a href="package-summary.html#StreamOps">quasi-intermediate
     * operation</a>.
     *
     * <p>
     * While this operation is quite cheap for sequential stream, it can be
     * quite expensive on parallel pipelines. Using unordered source or making it
     * explicitly unordered with {@link #unordered()} call may improve the parallel
     * processing performance if semantics permit.
     *
     * @param predicate a non-interfering, stateless predicate to apply to
     *                  elements.
     * @return the new stream.
     * @see #takeWhile(Predicate)
     * @since 0.5.5
     */
    public S takeWhileInclusive(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        Spliterator<T> spltr = spliterator();
        return supply(
                spltr.hasCharacteristics(Spliterator.ORDERED) ? new TakeDrop.TDOfRef<>(spltr, false, true, predicate)
                        : new TakeDrop.UnorderedTDOfRef<T>(spltr, false, true, predicate));
    }

    /**
     * Returns a stream consisting of all elements from this stream starting
     * from the first element which does not match the given predicate. If the
     * predicate is true for all stream elements, an empty stream is returned.
     *
     * <p>
     * This is a stateful operation. It can be either <a
     * href="package-summary.html#StreamOps">intermediate or
     * quasi-intermediate</a>. When using with JDK 1.9 or higher it calls the
     * corresponding JDK 1.9 implementation. When using with JDK 1.8 it uses own
     * implementation.
     *
     * <p>
     * While this operation is quite cheap for sequential stream, it can be
     * quite expensive on parallel pipelines. Using unordered source or making it
     * explicitly unordered with {@link #unordered()} call may improve the parallel
     * processing performance if semantics permit.
     *
     * @param predicate a non-interfering, stateless predicate to apply to
     *                  elements.
     * @return the new stream.
     * @since 0.3.6
     */
    public S dropWhile(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return VerSpec.VER_SPEC.callWhile(this, predicate, true);
    }

    /**
     * Returns a stream containing cumulative results of applying the
     * accumulation function going left to right.
     *
     * <p>
     * This is a stateful <a
     * href="package-summary.html#StreamOps">quasi-intermediate</a> operation.
     *
     * <p>
     * This operation resembles {@link #scanLeft(BinaryOperator)}, but unlike
     * {@code scanLeft} this operation is intermediate and accumulation function
     * must be associative.
     *
     * <p>
     * This method cannot take all the advantages of parallel streams as it must
     * process elements strictly left to right. Using an unordered source or
     * removing the ordering constraint with {@link #unordered()} may improve
     * the parallel processing speed.
     *
     * @param op an <a
     *           href="package-summary.html#Associativity">associative</a>, <a
     *           href="package-summary.html#NonInterference">non-interfering </a>,
     *           <a href="package-summary.html#Statelessness">stateless</a>
     *           function for computing the next element based on the previous one
     * @return the new stream.
     * @see #scanLeft(BinaryOperator)
     * @since 0.6.1
     */
    public S prefix(BinaryOperator<T> op) {
        Spliterator<T> spltr = spliterator();
        return supply(spltr.hasCharacteristics(Spliterator.ORDERED) ? new PrefixOps.OfRef<>(spltr, op)
                : new PrefixOps.OfUnordRef<T>(spltr, op));
    }

    // Necessary to generate proper JavaDoc
    @SuppressWarnings("unchecked")
    @Override
    public <U> U chain(Function<? super S, U> mapper) {
        return mapper.apply((S) this);
    }
}
