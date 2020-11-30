package com.example.webflux.demo;

import reactor.core.publisher.Flux;

public class Test2 {
 
    public static void main(String[] args){
        Flux.just("瓜田李下","瓜田李下 2","瓜田李下 3","瓜田李下 4","瓜田李下 5","瓜田李下 6")
                .toIterable().forEach(System.out::println);
 
        Flux.just("1 ","2 ","3 ","4 ","5 ","6 ").toStream().forEach(System.out::print);
 
        System.out.println("\n\n************");
        String s=Flux.just("瓜田李下","瓜田李下 2").elementAt(0)
                .flux().toIterable().iterator().next();
        System.out.println("flux 第0个元素为："+s);
 
        String s2=Flux.just("hello world","hello world 2","hello world 3").last()
                .flux().toIterable().iterator().next();
        System.out.println("flux 最后一个元素为："+s2);
    }
}