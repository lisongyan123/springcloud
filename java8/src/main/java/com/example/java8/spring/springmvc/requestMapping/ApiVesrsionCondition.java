package com.example.java8.spring.springmvc.requestMapping;

import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;

public class ApiVesrsionCondition implements RequestCondition<ApiVesrsionCondition> {
 
    private int apiVersion;
     
    public ApiVesrsionCondition(int apiVersion){
        this.apiVersion = apiVersion;
    }
     
    public ApiVesrsionCondition combine(ApiVesrsionCondition other) {
        // 采用最后定义优先原则，则方法上的定义覆盖类上面的定义
        return new ApiVesrsionCondition(other.getApiVersion());
    }
 
    public ApiVesrsionCondition getMatchingCondition(HttpServletRequest request) {
    	String ver = request.getHeader("Api-Version");
    	//因为请求头里面传来的是小数，所以需要乘以10
    	int version = (int) (Double.valueOf(ver) * 10);
    	if(version >= this.apiVersion) // 如果请求的版本号大于等于配置版本号， 则满足
            return this;
    	
        return null;
    }
 
    public int compareTo(ApiVesrsionCondition other, HttpServletRequest request) {
        // 优先匹配最新的版本号
        return other.getApiVersion() - this.apiVersion;
    }
 
    public int getApiVersion() {
        return apiVersion;
    }
 
}
