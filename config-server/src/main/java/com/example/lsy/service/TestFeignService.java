package com.example.lsy.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "cloud-zuul") //声明我们需要去调用的实例的名称
@Component
public interface TestFeignService {

    // 调用的方法
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String feign(@RequestParam(value = "name") String name);
}