//package com.springcloud.lsy.gateway.factory;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
//import org.springframework.http.HttpHeaders;
//import org.springframework.web.server.ServerWebExchange;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.function.Predicate;
//
///**
// * 自定义predicate断言
// */
//@Slf4j
//public class TokenRoutePredicateFactory extends AbstractRoutePredicateFactory<TokenRoutePredicateFactory.Config> {
//
//    private static final String DATETIME_KEY = "headerName";
//
//    public TokenRoutePredicateFactory() {
//        super(Config.class);
//    }
//
//    //config对应的字段
//    @Override
//    public List<String> shortcutFieldOrder() {
//        return Collections.singletonList(DATETIME_KEY);
//    }
//
//    @Override
//    public Predicate<ServerWebExchange> apply(Config config) {
//        log.debug("TokenRoutePredicateFactory Start...");
//        return exchange -> {
//            //判断header里有放token
//            HttpHeaders headers = exchange.getRequest().getHeaders();
//            List<String> header = headers.get(config.getHeaderName());
//            log.info("Token Predicate headers:{}", header);
//            return header.size() > 0;
//        };
//    }
//
//    public static class Config {
//        /**
//         * 传输token header key
//         */
//        private String headerName;
//
//        public String getHeaderName() {
//            return headerName;
//        }
//
//        public void setHeaderName(String headerName) {
//            this.headerName = headerName;
//        }
//    }
//}
//
