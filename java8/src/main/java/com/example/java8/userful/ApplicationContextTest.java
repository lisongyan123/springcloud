package com.example.java8.userful;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ApplicationContextTest {

    @Bean(name="sb")
    @Scope("singleton")
    public User ttt() {
        User user = new User();
        user.setName("user_1");
        user.setPwd("1234");
        return user;
    }
    
    public static void main(String[] args) {
        
        //通过applicationContext方式
        ApplicationContext atc = new AnnotationConfigApplicationContext(ApplicationContextTest.class);
        User user = (User)atc.getBean("sb");
        System.out.println(user.getPwd());
        
        //通过注册的方式
        AnnotationConfigApplicationContext acc = new AnnotationConfigApplicationContext();
        acc.register(ApplicationContextTest.class);
        acc.refresh();
        User _user = (User)acc.getBean("sb");
        System.out.println(_user.getName());
    }
}

class User {
    
    private String name;
    private String pwd;
    
    public User() {
        
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public User(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }
}