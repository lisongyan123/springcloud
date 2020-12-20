package com.example.java8.spring.springmvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.*;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Set;

@Component
public class MongoRequestHandlerMapping extends RequestMappingHandlerMapping {

    private static final Logger LOGGER = LoggerFactory.getLogger(MongoRequestHandlerMapping.class);

    /**
     * 是否由当前 handler 处理
     */
    @Override
    protected boolean isHandler(Class<?> beanType) {
        Method[] methods = ReflectionUtils.getAllDeclaredMethods(beanType);
        for (Method method : methods) {
            if (AnnotationUtils.findAnnotation(method, MongoRequestMapping.class) != null) {
                LOGGER.debug("[MongoRequestHandlerMapping] Method " + method + " supports @MongoRequestMapping ");
                return true;
            }
        }
        return false;
    }

    /**
     * 映射匹配，执行的操作
     */
    @Override
    protected void handleMatch(RequestMappingInfo info, String lookupPath, HttpServletRequest request) {
        LOGGER.debug("[MongoRequestHandlerMapping] handleMatch info " + info + ", lookupPath =" + lookupPath + ", request =" + request);
        request.setAttribute("isMongo", true);
        request.setAttribute("handledTime", System.nanoTime());
    }

    /**
     * URL路径和当前Handler不匹配
     */
    @Override
    protected HandlerMethod handleNoMatch(Set<RequestMappingInfo> requestMappingInfos, String lookupPath, HttpServletRequest request) throws ServletException {
        LOGGER.debug("[MongoRequestHandlerMapping] handleNoMatch info " + requestMappingInfos + ", lookupPath =" + lookupPath + ", request =" + request);
        return null;
    }

    /**
     * 通过Mapping注解构造 RequestMappingInfo 信息
     */
    @Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        LOGGER.debug("[MongoRequestHandlerMapping] getMappingForMethod method " + method + ", handlerType =" + handlerType);
        RequestMappingInfo info = null;
        // look for @DumberRequestMapping annotation for the Method method from signature
        MongoRequestMapping methodAnnotation = AnnotationUtils.findAnnotation(method, MongoRequestMapping.class);
        if (methodAnnotation != null) {
            RequestCondition<?> methodCondition = getCustomMethodCondition(method);
            info = createRequestMappingInfo(methodAnnotation, methodCondition);
        }
        LOGGER.debug("[MongoRequestHandlerMapping] getMappingForMethod method; returns info mapping " + info);
        return info;
    }

    /**
     * 构造 RequestMappingInfo 实例
     */
    protected RequestMappingInfo createRequestMappingInfo(MongoRequestMapping annotation, RequestCondition<?> customCondition) {
        return new RequestMappingInfo(
                new PatternsRequestCondition(new String[]{annotation.value()}),
                new RequestMethodsRequestCondition(new RequestMethod[]{RequestMethod.GET}),
                new ParamsRequestCondition(new String[]{}),
                new HeadersRequestCondition(new String[]{}),
                new ConsumesRequestCondition(new String[]{}, new String[]{}),
                new ProducesRequestCondition(new String[]{}, new String[]{}, getContentNegotiationManager()),
                customCondition);
    }


    /**
     * 属性设置
     */
    @Override
    public void afterPropertiesSet() {
        // 提升当前 HandlerMapping 的在映射处理器列表中的顺序
        super.setOrder(0);
        super.afterPropertiesSet();
    }
}

