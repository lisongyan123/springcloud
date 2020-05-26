package com.example.lsy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/service")
public class Controller {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    public String getFirstProduct() {
        return this.restTemplate.getForObject("https://STORES/products/1", String.class);
    }

    @RequestMapping("/getUrl")
    public List serviceUrl() {
        List<ServiceInstance> list = discoveryClient.getInstances("STORES");
        if (list != null && list.size() > 0 ) {
            return list;
        }
        return null;
    }
    @RequestMapping("/hello")
    public String hello(){
        return "hello，service";
    }
}
