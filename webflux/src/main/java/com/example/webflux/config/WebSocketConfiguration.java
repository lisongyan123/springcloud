package com.example.webflux.config;

import com.example.webflux.handler.EchoHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class WebSocketConfiguration {

    @Autowired
    @Bean
    public HandlerMapping webSocketMapping(final EchoHandler echoHandler) {
        final Map<String, WebSocketHandler> map = new HashMap<>();
        map.put("/echo", echoHandler);

        final SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        mapping.setOrder(Ordered.HIGHEST_PRECEDENCE);
        mapping.setUrlMap(map);
        return mapping;
    }

    @Bean
    public WebSocketHandlerAdapter handlerAdapter() {
        return new WebSocketHandlerAdapter();
    }


//    @GetMapping(value="files/{name}",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//    Flux<String> files(@PathVariable String name) {
//        return Flux.create((FluxSink<String> sink) -> {
//            FluxSink<String> serialize = sink.serialize();
//            MessageHandler handler = msg -> serialize.next(String.class.cast(msg.getPayload()));
//            serialize.setCancellation(() -> filesChannel().unsubscribe(handler));
//            filesChannel().subscribe(handler);
//        });
//    }
}
