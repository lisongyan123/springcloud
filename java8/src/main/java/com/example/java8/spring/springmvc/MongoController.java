package com.example.java8.spring.springmvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MongoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MongoController.class);

    @ResponseBody
    @MongoRequestMapping(value = "/test")
    public Map<String,Object> testSession(HttpServletRequest request) {
        LOGGER.debug("Is Mongo request ?"+request.getAttribute("isMongo"));
        LOGGER.debug("Handled time ?"+request.getAttribute("handledTime"));
        Map<String,Object> map = new HashMap<>(2);
        map.put("success", true);
        map.put("code", 200);
        map.put("result", "testTemplate");
        return map;
    }

}
