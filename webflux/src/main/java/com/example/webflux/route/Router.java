package com.example.webflux.route;

import com.example.webflux.controller.domain.User;
import com.example.webflux.handler.CalculatorHandler;
import com.example.webflux.handler.QuoteHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.*;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

public class Router {

    @Bean
    public RouterFunction<ServerResponse> route(QuoteHandler quoteHandler) {
        return RouterFunctions.route(GET("/hello2").and(accept(TEXT_PLAIN)), quoteHandler::hello)
                .andRoute(POST("/echo").and(accept(TEXT_PLAIN).and(contentType(TEXT_PLAIN))), quoteHandler::echo)
                .andRoute(GET("/quotes").and(accept(APPLICATION_JSON)), quoteHandler::fetchQuotes)
                .andRoute(GET("/quotes").and(accept(APPLICATION_STREAM_JSON)), quoteHandler::streamQuotes);
    }

    @Bean
    public RouterFunction<ServerResponse> routeCity(QuoteHandler.CityHandler cityHandler) {
        return RouterFunctions
                .route(GET("/hello").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                        cityHandler::helloCity);
    }

    @Bean
    public RouterFunction<ServerResponse> route() {
        return RouterFunctions.route(
                GET("/"), request -> {
                    Mono<User> user = Mono.just(new User("1", "a"));
                    return ok().body(fromPublisher(user, User.class));
                });
    }

    @Bean
    public RouterFunction<ServerResponse> initRouterFunction() {
        return RouterFunctions.route()
                .GET("/test/**", serverRequest -> {
                    System.out.println("path：" + serverRequest.exchange().getRequest().getPath().pathWithinApplication().value());

                    return ServerResponse.ok().syncBody("hello world");
                })
                .filter((serverRequest, handlerFunction) -> {
                    System.out.println("custom filter");

                    return handlerFunction.handle(serverRequest);
                })
                .build();
    }

    /**
     * RouterFunctions.route 用来根据 Predicate 是否匹配来确定 HandlerFunction 是否被应用。
     * RequestPredicates 中包含了很多静态方法来创建常用的基于不同匹配规则的 Predicate。
     * 如 RequestPredicates.path 用来根据 HTTP 请求的路径来进行匹配。此处我们检查请求的路径是/calculator。
     * 我们首先使用 ServerRequest 的 queryParam 方法来获取到查询参数 operator 的值，
     * 然后通过反射 API 在类 CalculatorHandler 中找到与查询参数 operator 的值名称相同的方法来确定
     * 要调用的 HandlerFunction 的实现，最后调用查找到的方法来处理该请求。如果找不到查询参数 operator
     * 或是 operator 的值不在识别的列表中，服务器端返回 400 错误；如果反射 API 的方法调用中出现错误，
     * 服务器端返回 500 错误。
     *
     * @param calculatorHandler
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> routerFunction(final CalculatorHandler calculatorHandler) {
        return RouterFunctions.route(
                RequestPredicates.path("/calculator"), request ->
                        request.queryParam("add").map(operator ->
                                Mono.justOrEmpty(ReflectionUtils.findMethod(CalculatorHandler.class, operator, ServerRequest.class))
                                        .flatMap(method -> (Mono<ServerResponse>) ReflectionUtils.invokeMethod(method, calculatorHandler, request))
                                        .switchIfEmpty(ServerResponse.badRequest().build())
                                        .onErrorResume(ex -> ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).build())
                        ).orElse(ServerResponse.badRequest().build())
        );
    }
}
