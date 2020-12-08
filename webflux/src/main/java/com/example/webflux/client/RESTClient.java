package com.example.webflux.client;

import com.example.webflux.controller.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
@Slf4j
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
    public static void main(final String[] args) throws IOException {
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

        //form提交
        String baseUrl = "http://localhost:8081";
        WebClient webClient = WebClient.create(baseUrl);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("username", "u123");
        map.add("password", "p123");
        Mono<String> mono = webClient.post().uri("/login").syncBody(map).retrieve().bodyToMono(String.class);

        WebClient.ResponseSpec retrieve = WebClient.create(baseUrl).post().retrieve();
        Mono<String> mono1 = retrieve
                .onStatus(e -> e.is4xxClientError(), resp -> {
                    System.out.println(resp.statusCode().value() + "," + resp.statusCode().getReasonPhrase());
                    return Mono.error(new RuntimeException(resp.statusCode().value() + " : " + resp.statusCode().getReasonPhrase()));
                })
                .bodyToMono(String.class)
                .doOnError(WebClientResponseException.class, err -> {
                    System.out.println(err.getRawStatusCode() + "," + err.getResponseBodyAsString());
                    throw new RuntimeException(err.getMessage());
                })
                .onErrorReturn("fallback");
        System.out.println("result:" + mono.block());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        HttpEntity<ClassPathResource> entity = new HttpEntity<>(new ClassPathResource("parallel.png"), headers);
        MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
        parts.add("file", entity);
        Mono<String> resp = WebClient.create().post()
                .uri("http://localhost:8080/upload")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromMultipartData(parts))
                .retrieve().bodyToMono(String.class);
        log.info("result:{}",resp.block());

        Mono<Resource> resp2 = WebClient.create().get()
                .uri("http://www.toolip.gr/captcha?complexity=99&size=60&length=9")
                .accept(MediaType.IMAGE_PNG)
                .retrieve().bodyToMono(Resource.class);
        Resource resource = resp2.block();
        BufferedImage bufferedImage = ImageIO.read(resource.getInputStream());
        ImageIO.write(bufferedImage, "png", new File("captcha.png"));

        String baseUrl1 = "http://localhost:8081";
        WebClient webClient1 = WebClient.create(baseUrl);

        MultiValueMap<String, String> map1 = new LinkedMultiValueMap<>();
        map.add("username", "u123");
        map.add("password", "p123");

        WebClient webClient3 = WebClient.builder().baseUrl(baseUrl).filter((request, next) -> {
            ClientRequest newRequest = ClientRequest.from(request).header("header1", "value1").build();
            Mono<ClientResponse> responseMono = next.exchange(newRequest);
            return Mono.fromCallable(() -> {
                ClientResponse response1 = responseMono.block();
                ClientResponse newResponse = ClientResponse.from(response1).header("responseHeader1", "Value1").build();
                return newResponse;
            });
        }).build();
    }
}