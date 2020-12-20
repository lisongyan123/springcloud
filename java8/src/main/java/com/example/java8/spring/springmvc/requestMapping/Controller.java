package com.example.java8.spring.springmvc.requestMapping;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 通过HTTP请求/test接口，分别带上请求头Api-Version=0.1、Api-Version=0.2、Api-Version=0.8测试，可以看到控制台分别输出：
 *
 * Api-Version=0.1：method—test1
 *
 * Api-Version=0.2：method—test2
 *
 * Api-Version=0.8：method—test2
 */
public class Controller {
    @ApiVersion(1)
    @RequestMapping("/test")
    public void test1() {
        System.out.println("method---test1");
    }

    @ApiVersion(2)
    @RequestMapping("/test")
    public void test2() {
        System.out.println("method---test2");
    }
}
