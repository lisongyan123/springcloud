package com.example.webflux.client;

import com.example.webflux.controller.domain.User;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class RESTClient {
    /**
     * 对于 HTTP 和 SSE，可以使用 WebFlux 模块中的类 org.springframework.web.reactive.function.client.WebClient。
     * RESTClient 用来访问前面小节中创建的 REST API。首先使用 WebClient.create 方法来创建一个新的
     * WebClient 对象，然后使用方法 post 来创建一个 POST 请求，并使用方法 body 来设置 POST 请求的内容。方法 exchange
     * 的作用是发送请求并得到以 Mono表示的 HTTP 响应。最后对得到的响应进行处理并输出结果。ServerResponse 的 bodyToMono
     * 方法把响应内容转换成类 User 的对象，最终得到的结果是 Mono对象。调用 createdUser.block 方法的作用是等待请求完
     * 成并得到所产生的类 User 的对象。
     * @param args
     */
    public static void main(final String[] args) {
        final User user = new User();
        user.setName("Test");
        user.setEmail("test@example.org");
        final WebClient client = WebClient.create("http://localhost:8080/user");
        final Mono<User> createdUser = client.post()
                .uri("")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(user), User.class)
                .exchange()
                .flatMap(response -> response.bodyToMono(User.class));
        System.out.println(createdUser.block());
    }
}