package com.example.java8.userful.annotation.appa;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Authors {

    Author[] value();

}
