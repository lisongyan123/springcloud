package com.springcloud.lsy.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 为什么要自定义过滤器，在某个场景，我们要统计某个服务响应时间
 * 下面写个局部过滤器
 */
@Slf4j
public class ElapsedFilter implements GatewayFilter, Ordered {
    //    假如我们要在代码中统计时间写如下语句很麻烦，可以用AOP，
//    但是每个服务写，也麻烦，所以自定义过滤器
//    long beginTime = System.currentTimeMillis();
//    // do something...
//    long elapsed = System.currentTimeMillis() - beginTime;
//    log.info("elapsed: {}ms", elapsed);
    private static final String ELAPSED_TIME_BEGIN = "elapsedTimeBegin";

    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getAttributes().put(ELAPSED_TIME_BEGIN, System.currentTimeMillis());
        //chain.filter(exchange) 之前的就是 “pre” 部分，之后的也就是 then 里边的是 “post” 部分。
        return chain.filter(exchange).then(
                //求某个服务的响应时间
                Mono.fromRunnable(() -> {
                    Long startTime = exchange.getAttribute(ELAPSED_TIME_BEGIN);
                    if (startTime != null) {
                        //从请求中获取uri 以及 启动的时间
                        log.info(exchange.getRequest().getURI().getRawPath() + ": " + (System.currentTimeMillis() - startTime) + "ms");
                    }
                })
        );
    }

    //给过滤器设定优先级别的，值越大则优先级越低。
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }

    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
        // @formatter:off
        return builder.routes()
                .route(r -> r.path("/fluent/customer/**")
                        .filters(f -> f.stripPrefix(2)
                                .filter(new ElapsedFilter())
                                .addResponseHeader("X-Response-Default-Foo", "Default-Bar"))
                        .uri("lb://CONSUMER")
                        .order(0)
                        .id("fluent_customer_service")
                ).build();
        // @formatter:on
    }

}