package com.example.java8.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ListenerEventDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "bean2.xml");
        EmailListEvent emailListEvent = new EmailListEvent("hello",
                "helloSpring@sina.com", "this is a test eamil content");
        //在ApplicationContext中发布一个 ApplicationEvent
        context.publishEvent(emailListEvent);
    }
}
