//package com.springcloud.lsy.gateway.rateLimit;
//
//import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
////使用ip作为限流键
//public class RemoteAddrKeyResolver implements KeyResolver {
//    public static final String BEAN_NAME = "remoteAddrKeyResolver";
//
//    @Override
//    public Mono<String> resolve(ServerWebExchange exchange) {
//        return Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
//    }
//
//}
