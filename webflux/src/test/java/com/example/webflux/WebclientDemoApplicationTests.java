package com.example.webflux;

import com.alibaba.fastjson.JSON;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.nio.charset.Charset;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@AutoConfigureWebTestClient(timeout = "1000000")//10 seconds WebTestClient 在5s超时 那就设置
public class WebclientDemoApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

//    @Test
//    public void test3GetSingleGithubRepository() {
//        webTestClient.get()
//                .uri("/api/repos/{repo}", "test-webclient-repository")
//                .exchange()
//                .expectStatus().isOk()
//                .expectBody()
//                .consumeWith(response ->
//                        Assertions.assertThat(response.getResponseBody()).isNotNull());
//    }
//
//
//    @Test
//    public void test5DeleteGithubRepository() {
//        webTestClient.delete()
//                .uri("/api/repos/{repo}", "updated-webclient-repository")
//                .exchange()
//                .expectStatus().isOk();
//    }

    @Test
    public void checkImpl() throws Exception {
        WebTestClient.BodyContentSpec bodyContentSpec = webTestClient.get().uri("/user/hello").exchange().expectStatus().isOk()
                .expectBody();
//		bodyContentSpec.jsonPath("$.current").exists();//判断json中路径current是否存在，类似的还有isNumber、isMap、isArray等判断方法。
        String body = new String(bodyContentSpec.returnResult().getResponseBody(), Charset.forName("utf8"));//获取body进行判断处理
        System.out.println("body:" + JSON.toJSON(body));
    }
}