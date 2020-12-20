package com.example.java8.spring.springmvc.requestMapping;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * 覆盖spring原生RequestMappingHandlerMapping类
 */
@Component
public class WebRequestMappingConfig implements WebMvcRegistrations {
	
	public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
		RequestMappingHandlerMapping handlerMapping = new CustomRequestMappingHandlerMapping();
		handlerMapping.setOrder(0);
		return handlerMapping;
	}

}
