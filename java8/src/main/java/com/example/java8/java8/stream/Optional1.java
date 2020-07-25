package com.example.java8.java8.stream;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Optional1 {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("bam");

        optional.isPresent();           // true
        optional.get();                 // "bam"
        optional.orElse("fallback");    // "bam"

        optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"
        optional.ifPresent((s) -> System.out.println(s.charAt(1)));     // "a"
        optional.ifPresent((s) -> System.out.println(s.charAt(2)));     // "m"

        System.out.println("===========================");

        test();
        test2();
        test4();

    }

    static class Foo {
        String name;
        List<Bar> bars = new ArrayList<>();

        Foo(String name) {
            this.name = name;
        }
    }

    static class Bar {
        String name;

        Bar(String name) {
            this.name = name;
        }
    }

    /**
     * 0-4的for循环写法
     */
    static void test() {
        IntStream.range(0, 4)
                .mapToObj(num -> new Foo("Foo" + num))
                .peek(f -> IntStream.range(0, 4)
                        .mapToObj(num -> new Bar("Bar" + num + " <- " + f.name))
                        .forEach(f.bars::add))
                .flatMap(f -> f.bars.stream())
                .forEach(b -> System.out.println(b.name));
    }

    private static void test4() {
        Stream
                .of(new BigDecimal("1.2"), new BigDecimal("3.7"))
                .mapToDouble(BigDecimal::doubleValue)
                .average()
                .ifPresent(System.out::println);
    }

    private static void test2() {
        IntStream
                .builder()
                .add(1)
                .add(3)
                .add(5)
                .add(7)
                .add(9)
                .build()
                .average()
                .ifPresent(System.out::println);

    }

}