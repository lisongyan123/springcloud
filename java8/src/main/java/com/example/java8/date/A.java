package com.example.java8.date;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class A {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println("date=" + date);
        LocalDate newDate = date.plus(1, ChronoUnit.YEARS);
        System.out.println("newDate=" + newDate);
    }
}
