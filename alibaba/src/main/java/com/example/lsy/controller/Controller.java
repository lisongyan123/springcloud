package com.example.lsy.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RefreshScope
public class Controller {

    @Value("${user.name:}")
    private String title;

    @GetMapping("/test")
    public String hello() {
        return title;
    }

}
