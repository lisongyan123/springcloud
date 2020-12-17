package com.example.java8.spring.beanDefinition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@ComponentScan("com.luban.beanDefinition")
@Configuration
public class Appconfig {
}

@Component
 class X {
    public X(){
        System.out.println("X Constructor");
    }
}

 class Y {
}

 class Test{
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(Appconfig.class);
        ac.refresh();
    }
}

