package com.springcloud.lsy.controller;

import org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gateway")
public class Controller {

    @RequestMapping("/default-error")
    public String DefaultErrorHandle(){
        return "这是通用错误处理返回的信息。";
    }

    @RequestMapping("/service-provider-error")
    public String ServiceProviderErrorHandle(){
        return "这是ServiceProvider服务专属的错误处理信息。";
    }

    @RequestMapping("/hello")
    public String hello(@RequestParam String name){
        return "hello，gateway" + name;
    }
}
