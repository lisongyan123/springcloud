package com.bank.irce.ltgj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
@MapperScan({"com.bank.irce.ltgj.mapper"})
public class LtgjAnalyseApplication {

    public static void main(String[] args) {
        SpringApplication.run(LtgjAnalyseApplication.class, args);
    }
}


