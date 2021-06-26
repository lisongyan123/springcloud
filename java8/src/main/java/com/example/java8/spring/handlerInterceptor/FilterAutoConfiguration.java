package com.example.java8.spring.handlerInterceptor;


import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;


@Configuration
public class FilterAutoConfiguration {


    @Configuration
    @ConditionalOnWebApplication
    @ConditionalOnClass({UserId.class, UserMobile.class})//多个用逗号隔开
    protected static class ArgumentResolverAutoConfiguration extends WebMvcConfigurerAdapter {
        protected ArgumentResolverAutoConfiguration() {
        }

        public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        //可添加多个
            argumentResolvers.add(new UserIdMethodArgumentResolver());
            argumentResolvers.add(new UserMobileMethodArgumentResolver());
        }
    }
}
