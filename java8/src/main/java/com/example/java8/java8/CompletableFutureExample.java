package com.example.java8.java8;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

public class CompletableFutureExample {

    public static void main(String[] args) {
        CompletableFuture.completedFuture("hello1");
        CompletableFuture.runAsync(() -> System.out.println("hello2"));
        CompletableFuture.runAsync(() -> System.out.println("hello3"), Executors.newSingleThreadExecutor());
        CompletableFuture.supplyAsync(() -> UUID.randomUUID().toString());
        CompletableFuture.supplyAsync(() -> UUID.randomUUID().toString(), Executors.newSingleThreadExecutor());
    }
}
