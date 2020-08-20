package com.bank.irce.ltgj.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Mapping2One {
    String value() default "映射缺失";
    //默认值
    String defaultValue();
    //正则
    String regex() default "";
}

