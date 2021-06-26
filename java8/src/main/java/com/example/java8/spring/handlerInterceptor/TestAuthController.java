package com.example.java8.spring.handlerInterceptor;


import org.apache.catalina.connector.Response;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
public class TestAuthController {
	@UserAuthenticate
	@GetMapping()
	public org.apache.catalina.connector.Response testAuth(@UserId Long userId, @UserMobile String userMobile) {
		System.out.println("userId : "+ userId + "  userMobile :" + userMobile);
		return new Response();
	}
}
