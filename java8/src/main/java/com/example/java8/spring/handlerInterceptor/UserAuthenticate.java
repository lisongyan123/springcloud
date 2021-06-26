package com.example.java8.spring.handlerInterceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface UserAuthenticate
{
	/**
	 * 是否需要校验访问权限 默认不校验
	 *
	 * @return
	 */
	boolean permission() default false;

}
