package com.example.webflux.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    public static void main(String[] args) {
        final String str1 = "abc";
        String c = new String("abc");
        final String str3 = str1 + "";
        final String str4 = "abc" + "";
        final boolean a = str3 == str4;
        boolean b = str3 == c;
        System.out.println(a);
        System.out.println(b);
    }
}