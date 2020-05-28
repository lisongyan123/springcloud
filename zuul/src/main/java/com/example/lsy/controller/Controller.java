package com.example.lsy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope // 自动刷新
@RestController
public class Controller {
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @Value("${name}")
    public String name;

    @Value("${age}")
    public Integer age;

    @RequestMapping("/hh")
    public String test(){
        return name + String.valueOf(age);
    }

    @Value("${server.port}")
    public Integer port;

    @RequestMapping("/port")
    public Integer port(){
        return port;
    }
}
