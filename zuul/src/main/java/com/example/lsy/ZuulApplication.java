package com.example.lsy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;

@EnableZuulProxy
@SpringBootApplication

public class ZuulApplication {

    public static void main(String[] args) {SpringApplication.run(ZuulApplication.class, args);}

    @Bean
    @RefreshScope
    @ConfigurationProperties("zuul")
    @Primary //必须
    public ZuulProperties zuulProperties(){
        return new ZuulProperties();
    }

}
