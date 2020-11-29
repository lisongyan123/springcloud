package com.example.webflux;

import com.example.webflux.controller.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.Duration;

@SpringBootApplication
public class WebfluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebfluxApplication.class, args);
    }

    /**
     * 远程调用接口
     */
//    @RestController
//    class UserController {
//        @GetMapping(value = "employees", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//        public Flux<User> findAll() {
//            return Flux.range(1, 5).map(val -> {
//                return list.stream().filter(employee -> employee.getId() == val).findFirst().get();
//            }).delayElements(Duration.ofMillis(1000));
//        }
//    }
//
//    @RestController
//    class UserController {
//        @GetMapping(value = "employees", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//        public Flux<User> findAll() {
//            return WebClient.create("localhost:8080/employees").get().retrieve().bodyToFlux(User.class);
//        }
//    }
}
