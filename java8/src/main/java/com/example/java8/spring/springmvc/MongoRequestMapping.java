package com.example.java8.spring.springmvc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MongoRequestMapping {

    /**
     * 映射的 URL 地址
     * @return
     */
    String value() default "";
}
