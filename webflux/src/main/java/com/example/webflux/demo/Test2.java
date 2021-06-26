package com.example.webflux.demo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

public class Test2 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Flux.just(list).toStream().forEach(System.out::println);
        Flux.just(list).toIterable().forEach(System.out::println);
        Flux.just(list).collectList().subscribe(System.out::println);
        System.out.println("**************************");
        Flux.just("瓜田李下", "瓜田李下 2", "瓜田李下 3", "瓜田李下 4", "瓜田李下 5", "瓜田李下 6")
                .toIterable().forEach(System.out::println);

        Flux.just("1 ", "2 ", "3 ", "4 ", "5 ", "6 ").toStream().forEach(System.out::print);


        Flux.just("1 ", "2 ", "3 ", "4 ", "5 ", "6 ").toStream().forEach(System.out::print);

        Flux.just(1, 20, 31, 4, 5, 6, 65, 23, 12, 32).sort()
                .subscribe(value -> System.out.print(value + "  "));

        System.out.println("\n\n************");
        String s = Flux.just("瓜田李下", "瓜田李下 2").elementAt(0)
                .flux().toIterable().iterator().next();
        System.out.println("flux 第0个元素为：" + s);

        Mono<String> s2 = Flux.just("hello world", "hello world 2", "hello world 3").last();
        System.out.println("flux 第0个元素为：" + s2);

        String s3 = Flux.just("hell" +
                "o world", "hello world 2", "hello world 3").last()
                .flux().toIterable().iterator().next();
        System.out.println("flux 最后一个元素为：" + s3);
    }
}