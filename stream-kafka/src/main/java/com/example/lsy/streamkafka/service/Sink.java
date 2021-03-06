package com.example.lsy.streamkafka.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * 接收器
 */
public interface Sink {
    String INPUT = "input";

    @Input("input")
    SubscribableChannel input();
}