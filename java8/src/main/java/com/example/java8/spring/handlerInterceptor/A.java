//package com.example.java8.spring.handlerInterceptor;
//
//import com.example.java8.spring.beanLife.Test;
//import org.apache.catalina.connector.Response;
//import org.assertj.core.internal.Urls;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//public class A {
//    @Idempotent(body = true,bodyVals = {"loan:loanNumber"})
//    @PostMapping(Urls.Test.V1_ADD)
//    @ResponseBody
//    public Response add(@RequestBody Test test) {
//        return null;
//    }
//
//}
