package com.example.webflux.demo;

import reactor.core.publisher.Mono;

public class FluxAndMono {
    /**
     * Mono.create()：使用 MonoSink 来创建 Mono
     * Mono.justOrEmpty()：从一个 Optional 对象或 null 对象中创建 Mono。
     * Mono.error()：创建一个只包含错误消息的 Mono
     * Mono.never()：创建一个不包含任何消息通知的 Mono
     * Mono.delay()：在指定的延迟时间之后，创建一个 Mono，产生数字 0 作为唯一值
     */

    /**
     * Flux 最值得一提的是 fromIterable 方法。
     * fromIterable(Iterable<? extends T> it)
     * 可以发布 Iterable 类型的元素。当然，Flux 也
     * 包含了基础的操作：
     * map、merge、concat、flatMap、take，这里就不展开介绍了。
     */
}

