package com.springcloud.lsy;

import com.springcloud.lsy.gateway.factory.MyGatewayFilterFactory;
import com.springcloud.lsy.gateway.filter.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@ComponentScan(value = "com.springcloud.lsy.dao")
//@MapperScan("com.springcloud.lsy.dao")
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }

    @Bean
    public MyGatewayFilterFactory exampleGatewayFilterFactory(){
        return new MyGatewayFilterFactory();
    }

}
