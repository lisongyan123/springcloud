package com.example.webflux.es;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class User{
	private String name;
	private int age;

	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}
}
