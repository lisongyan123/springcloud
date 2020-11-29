package com.example.webflux.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class CustomRouterConfig {
 
    @Bean
    public RouterFunction<ServerResponse> initRouterFunction(){
        return RouterFunctions.route()
                .GET("/test/**",serverRequest -> {
                    System.out.println("path："+serverRequest.exchange().getRequest().getPath().pathWithinApplication().value());
 
                    return ServerResponse.ok().syncBody("hello world");
                })
                .filter((serverRequest, handlerFunction) -> {
                    System.out.println("custom filter");
 
                    return handlerFunction.handle(serverRequest);
                })
                .build();
    }
}