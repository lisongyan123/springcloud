package com.example.java8.interfaces;

public interface Example {
    default void newMethod() {
        System.out.println("newMethod");
    }
}


class ExampleImpl implements Example {
    public static void main(String[] args) {
        Example example = new ExampleImpl();
        example.newMethod();
    }
}
