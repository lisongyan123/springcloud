package com.example.webflux.demo;

import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Test7 {

    static class Person {

        private String name;
        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person)) return false;
            Person person = (Person) o;
            return Objects.equals(getName(), person.getName()) &&
                    Objects.equals(getAge(), person.getAge());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getName(), getAge());
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {
        Mono.fromCallable(() -> {
            Map<String, String> map = new HashMap<>();
            map.put("name", "瓜田李下");
            map.put("age", "20");

            return map;
        }).flatMap(map -> {
            Person person = new Person();
            person.setName(map.get("name"));
            person.setAge(Integer.parseInt(map.get("age")));

            return Mono.just(person);
        }).subscribe(System.out::println);

        Mono.fromCallable(() -> {
            Map<String, String> map = new HashMap<>();
            map.put("name", "瓜田李下");
            map.put("age", "20");

            return map;
        }).map(map -> {
            Person person = new Person();
            person.setName(map.get("name"));
            person.setAge(Integer.parseInt(map.get("age")));

            return person;
        }).subscribe(System.out::println);

        Mono.fromCallable(() -> {
            Map<String, String> map = new HashMap<>();
            map.put("name", "瓜田李下");
            map.put("age", "20");

            return map;
        }).transform(mono -> mono.map(map -> {
            Person person = new Person();
            person.setName(map.get("name"));
            person.setAge(Integer.parseInt(map.get("age")));

            return person;
        })).subscribe(System.out::println);

        Mono.fromCallable(() -> {
            Map<String, String> map = new HashMap<>();
            map.put("name", "瓜田李下");
            map.put("age", "20");

            return map;
        }).transform(mono -> mono.flatMap(map -> {
            Person person = new Person();
            person.setName(map.get("name"));
            person.setAge(Integer.parseInt(map.get("age")));

            return Mono.just(person);
        })).subscribe(System.out::println);
    }
}