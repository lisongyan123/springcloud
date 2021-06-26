package com.example.java8.date;

import lombok.Data;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class Date {

    private final DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy-MM");

    @Data
    public static class People {
        BigDecimal age;
        BigDecimal money;
    }

    public static void main(String[] args) {
        People people = new People();
        System.out.println(people.getAge());
        System.out.println(people.getAge().compareTo(new BigDecimal(0)));
    }
}
