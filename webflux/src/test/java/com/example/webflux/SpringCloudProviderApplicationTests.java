package com.example.webflux;


import com.example.webflux.controller.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
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
import java.nio.charset.Charset;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Slf4j
public class SpringCloudProviderApplicationTests {
	protected WebTestClient rest;
	@LocalServerPort
	private int port = 8103;


	@Test
	public void checkImpl() throws Exception{
        final User user = new User();
        user.setName("Test");
        user.setEmail("test@example.org");
        final WebClient client = WebClient.create("http://localhost:8080/user");
        final Mono<User> createdUser = client.post()
                .uri("")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(user), User.class)
                .exchangeToMono(response -> response.bodyToMono(User.class));
        System.out.println(createdUser.block());


        //form提交
        String baseUrl = "http://localhost:8080";
        WebClient webClient = WebClient.create(baseUrl);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("username", "u123");
        map.add("password", "p123");
        Mono<String> mono = webClient.post().uri("/login").bodyValue(map).retrieve().bodyToMono(String.class);


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
                }).onErrorReturn("fallback");
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

        String baseUrl1 = "http://localhost:8080";
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
