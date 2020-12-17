package com.example.webflux.demo;

import reactor.core.publisher.Mono;

public class Test8 {
 
    public static void main(String[] args){
        Mono.just(2).filter(integer -> integer>1).subscribe(System.out::println);
 
        System.out.println("\n***************");
        Mono.just(2).filter(integer -> integer>2).subscribe(System.out::println);
    }
}