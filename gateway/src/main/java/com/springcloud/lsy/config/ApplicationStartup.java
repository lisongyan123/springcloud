//package com.springcloud.lsy.config;
//
//import com.springcloud.lsy.service.GatewayDefineService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//
///**
// * 在Spring Boot程序启动后会检测程序中是否有CommandLineRunner
// * 和ApplicationRunner接口的实例，
// * 如果存在，则会执行对应实现类中的run()方法，而且只执行一次
// */
//public class ApplicationStartup implements ApplicationRunner {
//
//    @Autowired
//    private GatewayDefineService gatewayDefineService;
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        gatewayDefineService.loadRouteDefinition();
//    }
//}
//
