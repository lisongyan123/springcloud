package com.example.lsy.streamkafka.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * 发射器
 */
public interface Source {
    String str = "myOutput";

    @Output("myOutput")
    MessageChannel output();
}
