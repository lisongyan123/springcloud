package com.example.cloudservice.controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import static com.example.cloudservice.common.helper.RequestHelper.*;

/**
 *   controller基础抽象类
 */
public abstract class BaseAction {

    /**
     * description 获得来的request中的 key value数据封装到map返回
     */
    @SuppressWarnings("rawtypes")
    protected Map<String, String> getRequestParameter(HttpServletRequest request) { return getRequestParameters(request); }

    protected Map<String,String> getRequestBody(HttpServletRequest request) {
        return getRequestBodyMap(request);
    }

    protected Map<String, String > getRequestHeader(HttpServletRequest request) {
        return getRequestHeaders(request);
    }
}
