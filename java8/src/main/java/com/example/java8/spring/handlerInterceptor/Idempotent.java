package com.example.java8.spring.handlerInterceptor;

import javax.ws.rs.NameBinding;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
@NameBinding
public @interface Idempotent
{
	/**
	 * 是否把body数据用来计算幂等key。如果没有登录信息，请设置这个值为true。主要用于第三方接入。
	 *
	 * @return
	 */
	boolean body() default false;

	/**
	 * body里的哪些字段用来计算幂等key。body()为true时才有生效。如果这个为空，则计算整个body。主要用于第三方接入。<br/>
	 * <p>
	 * 字段命名规则：<br/>
	 * path: Like xpath, to find the specific value via path. Use :(Colon) to separate different key name or index.
	 * For example:
	 * 	JSON content:
	 * 		{
	 * 			"name": "One Guy",
	 * 			"details": [
	 * 				{"education_first": "xx school"},
	 * 				{"education_second": "yy school"},
	 * 				{"education_third": "zz school"},
	 * 				...
	 * 			],
	 * 			"loan": {"loanNumber":"1234567810","loanAmount":1000000},
	 * 		}
	 *
	 * To find the value of "name", the path="name".
	 * To find the value of "education_second", the path="details:0:education_second".
	 * To find the value of "loanNumber"  , the path="loan:loanNumber".
	 * To find the value of "name" and "loanNumber"  , the path="name","loan:loanNumber".
	 *
	 * @return
	 */
	String[] bodyVals() default {};

	/**
	 * idempotent lock失效时间，in milliseconds。一些处理时间较长或者数据重复敏感的接口，可以适当设置长点时间。
	 *
	 * @return
	 */
	int expiredTime() default 60000;

}
