package com.example.webflux.demo;

import reactor.core.publisher.Mono;

public class Test10 {

    public static void main(String[] args) {
        Mono.just("hello world").subscribe(System.out::println);

        System.out.println("\n*************");
        Mono.just("hello world 2").log().subscribe(System.out::println);
    }
}