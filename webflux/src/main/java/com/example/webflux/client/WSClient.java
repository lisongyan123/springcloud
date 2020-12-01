package com.example.webflux.client;

import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import org.springframework.web.reactive.socket.client.WebSocketClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class WSClient {
    public static void main(final String[] args) {
        final WebSocketClient client = new ReactorNettyWebSocketClient();
        client.execute(URI.create("ws://localhost:8080/echo"), session ->
                session.send(Flux.just(session.textMessage("Hello")))
                        .thenMany(session.receive().take(1).map(WebSocketMessage::getPayloadAsText))
                        .doOnNext(System.out::println)
                        .then())
                .block(Duration.ofMillis(5000));

        //        WebClient client = WebClient.create("http://www.kailing.pub");
//        /**Post请求  map也可以这么写*/
//        BodyInserters.FormInserter formInserter = fromMultipartData("name","kl")
//                .with("age",19)
//                .with("map",ImmutableMap.of("xx","xx"))
//                .with("file",new File("E://xxx.doc"));
//        Mono<String> result = client
//                .post()
//                .uri("/article/index/arcid/{id}.html", 256)
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(formInserter)
//                .bodyValue(ImmutableMap.of("name","kl"))
//                .retrieve()
//                .bodyToMono(String.class);
//        result.subscribe(System.err::println);

        //但是，如果需要进行多个调用，则更高效地方式是避免单独阻塞每个响应，而是等待组合结果
        WebClient client2 =  WebClient.create("http://www.kailing.pub");
        Mono<String> result1Mono = client2.get()
                .uri("/article/index/arcid/{id}.html", 255)
                .retrieve()
                .bodyToMono(String.class);
        Mono<String> result2Mono = client2.get()
                .uri("/article/index/arcid/{id}.html", 254)
                .retrieve()
                .bodyToMono(String.class);
        Map<String,String> map = Mono.zip(result1Mono, result2Mono, (result1, result2) -> {
            Map<String, String> arrayList = new HashMap<>();
            arrayList.put("result1", result1);
            arrayList.put("result2", result2);
            return arrayList;
        }).block();
        System.err.println(map.toString());

        /**
         * filter拦截器，统一修改拦截请求，比如认证的场景，如下示例，filter注册单个拦截器，
         * filters可以注册多个拦截器，basicAuthentication是系统内置的用于basicAuth的拦截器，
         * limitResponseSize是系统内置用于限制响值byte大小的拦截器
         */
        WebClient.builder()
                .baseUrl("http://www.kailing.pub")
                .filter((request, next) -> {
                    ClientRequest filtered = ClientRequest.from(request)
                            .header("foo", "bar")
                            .build();
                    return next.exchange(filtered);
                })
                .filters(filters ->{
                    filters.add(ExchangeFilterFunctions.basicAuthentication("username","password"));
                    filters.add(ExchangeFilterFunctions.limitResponseSize(800));
                })
                .build().get()
                .uri("/article/index/arcid/{id}.html", 254)
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(System.err::println);
    }
}