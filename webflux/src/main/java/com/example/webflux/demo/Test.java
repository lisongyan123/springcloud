package com.example.webflux.demo;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) throws Exception {
        Flux.defer(() -> Flux.just("hello world " + System.currentTimeMillis()))
                .delaySubscription(Duration.ofSeconds(2))
                .subscribe(s -> {
                    System.out.println(s);
                    System.out.println("hello world " + System.currentTimeMillis());
                });

        Flux.just("hello world2 " + System.currentTimeMillis())
                .delaySubscription(Duration.ofSeconds(2))
                .subscribe(s -> {
                    System.out.println(s);
                    System.out.println("hello world2 " + System.currentTimeMillis());
                });

        TimeUnit.SECONDS.sleep(6);
    }
}