//package com.example.webflux;
//
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.reactive.server.WebTestClient;
//
//import java.nio.charset.Charset;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class SpringCloudProviderApplicationTests {
//	protected WebTestClient rest;
//	@LocalServerPort
//	private int port = 8103;
//
//
//	@Test
//	public void checkImpl() throws Exception{
//		WebTestClient.BodyContentSpec bodyContentSpec= rest.get().uri("/user").exchange().expectStatus().isOk()
//				.expectBody();
//		bodyContentSpec.jsonPath("$.current").exists();//判断json中路径current是否存在，类似的还有isNumber、isMap、isArray等判断方法。
//		String body=new String(bodyContentSpec.returnResult().getResponseBody(), Charset.forName("utf8"));//获取body进行判断处理
//	}
//
//}
