package com.example.webflux.demo;

import reactor.core.publisher.Flux;

public class Test4 {
 
    public static void main(String[] args){
        Flux.zip(Flux.just("hello world "),Flux.just("2"),(value1, value2) -> value1+value2)
                .subscribe(System.out::println);
 
        Flux.combineLatest(Flux.just("hello world"),Flux.just("3"),Flux.just("4"),
                array -> {
                    StringBuilder result= new StringBuilder();
                    for (Object o : array) {
                        result.append(o).append("  ");
                    }

                    return result.toString();
                }).subscribe(System.out::println);
    }
}