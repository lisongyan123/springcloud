package com.example.java8.userful.streamex;

import java.util.Objects;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;
import java.util.stream.*;

interface java9<T> {
    default Stream<T> takeWhile(Predicate<? super T> predicate) {
    Objects.requireNonNull(predicate);
    // Reuses the unordered spliterator, which, when encounter is present,
    // is safe to use as long as it configured not to split
    return StreamSupport.stream(
            new WhileOps.UnorderedWhileSpliterator.OfRef.Taking<>(spliterator(), true, predicate),
            isParallel()).onClose(this::close);
}

}
public class Java9Specific extends VersionSpecific {
    @Override
    <T, S extends AbstractStreamEx<T, S>> S callWhile(AbstractStreamEx<T, S> stream, Predicate<? super T> predicate, boolean drop) {
        Stream<T> upStream = stream.stream();
        return stream.supply(drop ? upStream.dropWhile(predicate) : upStream.takeWhile(predicate));
    }

    @Override
    final IntStreamEx callWhile(IntStreamEx stream, IntPredicate predicate, boolean drop) {
        IntStream upStream = stream.stream();
        return new IntStreamEx(drop ? upStream.dropWhile(predicate) : upStream.takeWhile(predicate), stream.context);
    }

    @Override
    final LongStreamEx callWhile(LongStreamEx stream, LongPredicate predicate, boolean drop) {
        LongStream upStream = stream.stream();
        return new LongStreamEx(drop ? upStream.dropWhile(predicate) : upStream.takeWhile(predicate), stream.context);
    }

    @Override
    final DoubleStreamEx callWhile(DoubleStreamEx stream, DoublePredicate predicate, boolean drop) {
        DoubleStream upStream = stream.stream();
        return new DoubleStreamEx(drop ? upStream.dropWhile(predicate) : upStream.takeWhile(predicate), stream.context);
    }

    @Override
    IntStream ofChars(CharSequence seq) {
        return seq.chars();
    }
}