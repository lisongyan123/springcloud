package com.example.java8.spring;

import org.springframework.cache.CacheManager;

public class CacheUtils {
	private static CacheManager cacheManager = ((CacheManager) SpringContextHolder.getBean("cacheManager"));
	private static HelloWorld helloWorld = ((HelloWorld) SpringContextHolder.getBean(HelloWorld.class));
}