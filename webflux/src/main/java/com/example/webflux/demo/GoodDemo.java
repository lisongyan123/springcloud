package com.example.webflux.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.springframework.web.reactive.function.BodyInserters.fromMultipartData;

@Slf4j
public class GoodDemo {
    public static void main(String[] args) {
        //同步执行乘法操作
        //运行8.353s
        log.info("同步执行乘法");
        Flux.just(1, 2, 3, 4, 5)
                .log()
                .map(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return i * 10;
                })
                .subscribe(c -> log.info("getInt:{}", c));

        log.info("异步执行乘法");
        //异步执行乘法  运行3.44s
        Flux.just(1, 2, 3, 4, 5)
                .log()
                .flatMap(i -> Flux.just(i * 10).delayElements(Duration.ofSeconds(1)))
                .subscribe(c -> log.info("getInt:{}", c));
    }
}
