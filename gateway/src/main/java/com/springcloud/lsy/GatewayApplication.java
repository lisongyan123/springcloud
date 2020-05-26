package com.springcloud.lsy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@ComponentScan(basePackages = "com.springcloud.lsy.dao")
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

//    @Bean
//    public ElapsedGatewayFilterFactory elapsedGatewayFilterFactory() {
//        return new ElapsedGatewayFilterFactory();
//    }
//
//    @Bean
//    public TokenFilter tokenFilter() {
//        return new TokenFilter();
//    }
//
//    @Bean(name = RemoteAddrKeyResolver.BEAN_NAME)
//    public RemoteAddrKeyResolver remoteAddrKeyResolver() {
//        return new RemoteAddrKeyResolver();
//    }
//
//    @Bean
//    @ConditionalOnMissingBean(RouteDefinitionRepository.class)
//    public InMemoryRouteDefinitionRepository inMemoryRouteDefinitionRepository() {
//        return new InMemoryRouteDefinitionRepository();
//    }

//    @Bean
//    public RouteDefinitionWriter routeDefinitionWriter() {
//        return new InMemoryRouteDefinitionRepository();
//    }

//    @Bean
//    public MysqlRouteDefinitionRepository mysqlRouteDefinitionRepository() {
//        return new MysqlRouteDefinitionRepository();
//    }


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
