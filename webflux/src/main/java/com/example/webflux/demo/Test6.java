package com.example.webflux.demo;

import reactor.core.publisher.Flux;

import java.util.Objects;

public class Test6 {

    public static void main(String[] args) {
        Flux.just(1, 2, 3, 4, 5, 6).groupBy(value -> value < 3)
                .subscribe(flux -> {
                    if (Objects.equals(flux.key(), Boolean.TRUE)) {
                        System.out.print("key为" + flux.key() + "的个数为：");
                        flux.count().subscribe(System.out::println);
                    }
                });
    }
}