package com.example.lsy.controller;

import com.example.lsy.service.TestFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class Controller {

    @Autowired
    TestFeignService testFeignService;

    @Resource
    FeignClient personFeignClient;

    PersonTest personTest;

    @RequestMapping("/hello")
    public String hello(){
        return "hello ,I am config-server";
    }

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        return testFeignService.feign(name);
    }

    @RequestMapping(value = "/serviceId",method = RequestMethod.GET)
    @ResponseBody
    public void test(@RequestParam String serviceId){
        String url = "http://cyn-admin";
        personTest.build(url);
    }

}
