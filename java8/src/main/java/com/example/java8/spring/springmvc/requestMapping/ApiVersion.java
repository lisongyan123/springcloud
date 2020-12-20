package com.example.java8.spring.springmvc.requestMapping;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 * 控制api版本注解
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface ApiVersion {

	int value();
	
}
