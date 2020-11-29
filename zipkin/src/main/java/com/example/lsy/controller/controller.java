package com.example.lsy.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/zipkin")
public class controller {
    @RequestMapping("/test")
    public String hello() {
        return "hello,zipkin";
    }
}
