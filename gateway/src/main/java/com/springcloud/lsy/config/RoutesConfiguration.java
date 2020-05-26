package com.springcloud.lsy.config;

import com.springcloud.lsy.gateway.factory.TokenRoutePredicateFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  代码配置路由，经过过滤器，拦截这个
 */
//@Configuration
public class RoutesConfiguration {

    /**
     * 代码配置路由
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes().route(predicateSpec ->
                predicateSpec.path("/order/**")
                        .and().asyncPredicate(initTokenRoutePredicateFactory().applyAsync(config -> config.setHeaderName("Authorization")))
                        .uri("lb://order-service").id("order-service")
        ).build();
    }

    @Bean
    public TokenRoutePredicateFactory initTokenRoutePredicateFactory(){
        return new TokenRoutePredicateFactory();
    }

}

