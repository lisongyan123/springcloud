package com.example.cloudservice.config.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Arrays;

@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAop {

    //业务逻辑类加入到容器中
    @Bean
    public MathCalculator mathCalculator() {
        System.out.println("mathCalculator bean");
        return new MathCalculator();
    }

    //切面类加入到容器中
    @Bean
    public LogAspects logAspects() {
        return new LogAspects();
    }


}


