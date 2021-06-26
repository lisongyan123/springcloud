package com.example.webflux.demo;

import reactor.core.publisher.Mono;

public class Test9 {

    public static void main(String[] args) throws Exception {
        Mono.just("hello world")
                .doOnNext(s -> System.out.println("next"))
                .doFinally(s -> System.out.println("finally"))
                .doAfterTerminate(() -> System.out.println("terminate"))
                .subscribe(System.out::println);
    }
}