package com.example.webflux.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuples;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 服务器推送事件
 * Created by mingge on 2018/5/4.
 */
@RestController
@RequestMapping("/sse")
@Slf4j
public class SseController {
    /**
     * 其中的方法 randomNumbers()表示的是每隔一秒产生一个随机数的 SSE 端点。
     * 我们可以使用类 ServerSentEvent.Builder 来创建 ServerSentEvent 对象。
     * 这里我们指定了事件名称 random，以及每个事件的标识符和数据。
     * 事件的标识符是一个递增的整数，而数据则是产生的随机数。
     * @return
     */
    @GetMapping("/randomNumbers")
    public Flux<ServerSentEvent<Integer>> randomNumbers() {
        log.info("开始啦----------------------------------------------------");
        return Flux.interval(Duration.ofSeconds(1))
                .map(seq -> Tuples.of(seq, ThreadLocalRandom.current().nextInt()))
                .map(data -> ServerSentEvent.<Integer>builder()
                        .event("random")
                        .id(Long.toString(data.getT1()))
                        .data(data.getT2())
                        .build());
    }
}