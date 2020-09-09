package com.example.java8.extra;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;
import java.util.function.Function;

@Slf4j
public class Something {
    public static <T, U> U function(T t, Consumer before, Consumer after, Function function) {
        before.accept(t);
        U result = (U) function.apply(t);
        after.accept(t);
        return result;
    }

    public static void main(String[] args) {
        Integer hello = 111;

    }

    public Integer returnIt(Integer hello) {
        Integer returnValue = function(hello,
                (val1) -> log.info("执行前" + val1),
                (val2) -> log.info("执行后", val2),
                (par) -> hello(par));
        return returnValue;

    }

    public static <T> T hello(T hello) {
        return hello;
    }
}
