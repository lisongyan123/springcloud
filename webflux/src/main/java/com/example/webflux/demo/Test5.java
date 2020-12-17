package com.example.webflux.demo;

import com.example.webflux.controller.domain.Person;
import reactor.core.publisher.Flux;

import java.util.HashMap;
import java.util.Map;

public class Test5 {

    /**
     * 打印结果是
     * Person{name='瓜田李下', age=20}
     * Person{name='瓜田李下', age=20}
     * Person{name='瓜田李下', age=20}
     * Person{name='瓜田李下', age=20}
     * Person{name='瓜田李下', age=20}
     * @param args
     */
    public static void main(String[] args){
        Map<String,String> map=new HashMap<>();
        map.put("name","瓜田李下");
        map.put("age","20");
 
        Flux.just(map).flatMap(m -> {
            String name=m.get("name");
            Integer age=Integer.parseInt(m.get("age"));
 
            Person person=new Person();
            person.setName(name);
            person.setAge(age);

            return Flux.just(person);
        }).subscribe(System.out::println);
 
        Flux.just(map).map(m -> {
            String name=m.get("name");
            Integer age=Integer.parseInt(m.get("age"));
 
            Person person=new Person();
            person.setName(name);
            person.setAge(age);
 
            return person;
        }).subscribe(System.out::println);
 
        Flux.just(map).transform(flux -> flux.flatMap(m -> {
            String name=m.get("name");
            Integer age=Integer.parseInt(m.get("age"));
 
            Person person=new Person();
            person.setName(name);
            person.setAge(age);
 
            return Flux.just(person);
        })).subscribe(System.out::println);
 
        Flux.just(map).transform(flux -> flux.map(m -> {
            String name=m.get("name");
            Integer age=Integer.parseInt(m.get("age"));
 
            Person person=new Person();
            person.setName(name);
            person.setAge(age);
 
            return person;
        })).subscribe(System.out::println);
 
        Flux.just(map).switchMap(m -> {
            String name=m.get("name");
            Integer age=Integer.parseInt(m.get("age"));
 
            Person person=new Person();
            person.setName(name);
            person.setAge(age);
 
            return Flux.just(person);
        }).subscribe(System.out::println);
    }
}