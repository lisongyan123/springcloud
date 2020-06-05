package com.example.cloudservice.common.helper;

import com.alibaba.fastjson.JSON;
import com.example.cloudservice.common.bean.ClientInfo;
import com.example.cloudservice.config.shiro.support.XssSqlHttpServletRequestWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.util.WebUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.regex.Pattern;

/**
 * 封装常见的Request方法
 */
@Slf4j
public class RequestHelper {


    /**
     * 生成Token
     * Token：Nv6RRuGEVvmGjB+jimI/gw==
     * @return
     */
    public String makeToken() {
        //checkException
        //  7346734837483  834u938493493849384  43434384
        String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";
        //数据指纹   128位长   16个字节  md5
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte md5[] = md.digest(token.getBytes());
            //base64编码--任意二进制编码明文字符   adfsdfsdfsf
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(md5);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 将所有的请求参数转换字符串
     * 例如:
     * uri?param1=111&param2=111,222
     *
     * @param request
     * @return
     */
    public static String requestParamsToString(ServletRequest request) {
        StringBuilder sbuf = new StringBuilder();
        Map<String, String[]> map = request.getParameterMap();
        if (map == null || map.size() == 0) {
            return "";
        }
        int i = 0;

        String arrayJoiner = ",";
        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            String joiner = "&";
            String key = entry.getKey();
            String[] value = entry.getValue();
            if (value != null && value.length == 1) {
                sbuf.append(joiner).append(key).append("=").append(value[0]);
            } else {
                sbuf.append(joiner).append(key).append("=").append(StringHelper.join(value, arrayJoiner));
            }
        }
        return sbuf.toString();
    }


    /**
     * 判断是否为ajax请求
     *
     * @param request
     * @return
     */
    public static boolean isAjax(HttpServletRequest request) {
        String header = request.getHeader("X-Requested-With");
        return "XMLHttpRequest".equalsIgnoreCase(header);
    }

    private static String longToIpV4(long longIp) {
        int octet3 = (int) ((longIp >> 24) % 256);
        int octet2 = (int) ((longIp >> 16) % 256);
        int octet1 = (int) ((longIp >> 8) % 256);
        int octet0 = (int) ((longIp) % 256);
        return octet3 + "." + octet2 + "." + octet1 + "." + octet0;
    }

    private static long ipV4ToLong(String ip) {
        String[] octets = ip.split("\\.");
        return (Long.parseLong(octets[0]) << 24) + (Integer.parseInt(octets[1]) << 16)
                + (Integer.parseInt(octets[2]) << 8) + Integer.parseInt(octets[3]);
    }

    private static boolean isIPv4Private(String ip) {
        long longIp = ipV4ToLong(ip);
        return (longIp >= ipV4ToLong("10.0.0.0") && longIp <= ipV4ToLong("10.255.255.255"))
                || (longIp >= ipV4ToLong("172.16.0.0") && longIp <= ipV4ToLong("172.31.255.255"))
                || longIp >= ipV4ToLong("192.168.0.0") && longIp <= ipV4ToLong("192.168.255.255");
    }

    private static boolean isIPv4Valid(String ip) {
        return Pattern.compile("^(?:" + "(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)" + "\\.){3}" + "(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)" + "$").matcher(ip).matches();
    }

    /**
     * 获取客户端请求的IP
     *
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        if (request == null) {
            return "unknown";
        }
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
    }

    /**
     * 获取请求参数
     *
     * @param request
     * @return
     */
    public static Map<String, Object> convertDataMap(HttpServletRequest request) {
        Map<String, String[]> properties = request.getParameterMap();
        Map<String, Object> returnMap = new HashMap<String, Object>();
        Iterator<?> entries = properties.entrySet().iterator();
        Map.Entry<?, ?> entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Map.Entry<?, ?>) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if (null == valueObj) {
                value = "";
            } else if (valueObj instanceof String[]) {
                String[] values = (String[]) valueObj;
                for (int i = 0; i < values.length; i++) {
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length() - 1);
            } else {
                value = valueObj.toString();
            }
            returnMap.put(name, value);
        }
        return returnMap;
    }

    /**
     * 获取请求参数
     *
     * @param request
     * @return
     */
    public static Map<String, Object> getParams(HttpServletRequest request) {
        Map<String, Object> map = new HashMap();
        Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);
            if (paramValues.length == 1) {
                String paramValue = paramValues[0];
                if (paramValue.length() != 0) {
                    map.put(paramName, paramValue);
                }
            }
        }
        return map;
    }

    /**
     * 获取请求参数
     *
     * @param request
     * @return
     */
    public static Map<String, Object> paramMaps(HttpServletRequest request) {
        Map<String, String[]> properties = request.getParameterMap();
        Map<String, Object> returnMap = new HashMap<String, Object>();
        Iterator<?> entries = properties.entrySet().iterator();
        Map.Entry<?, ?> entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Map.Entry<?, ?>) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if (null == valueObj) {
                value = "";
            } else if (valueObj instanceof String[]) {
                String[] values = (String[]) valueObj;
                for (int i = 0; i < values.length; i++) {
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length() - 1);
            } else {
                value = valueObj.toString();
            }
            returnMap.put(name, value);
        }
        return returnMap;
    }

    /**
     * 获取整型参数
     *
     * @param request
     * @param paramName
     * @return
     */
    public static Integer paramInteger(HttpServletRequest request, String paramName) {
        String parameter = request.getParameter(paramName);
        Integer value = null;
        try {
            value = Integer.parseInt(parameter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * 获取客户端请求信息
     */
    public static ClientInfo clientInfo(HttpServletRequest request) {
        ClientInfo info = new ClientInfo();
        info.setReqTime(System.currentTimeMillis());
        info.setClientIp(getIpAddr(request));
        info.setReferer(request.getHeader("referer"));
        info.setUri(request.getRequestURI());

        String ua = request.getHeader("User-Agent");
        info.setUserAgents(ua);
        ua = ua.toUpperCase();

        if (ua.contains("WINDOWS NT 5.1")) {
            info.setPlatform("WindowsVista");
        }
        if (ua.contains("WINDOWS NT 6.1")) {
            info.setPlatform("Windows7");
        }
        if (ua.contains("WINDOWS NT 6.2")) {
            info.setPlatform("Windows8");
        }
        if (ua.contains("WINDOWS NT 10")) {
            info.setPlatform("Windows10");
        }
        if (ua.contains("MAC")) {
            info.setPlatform("MacOS");
        }
        if (ua.contains("LINUX")) {
            info.setPlatform("Linux");
        }
        if (ua.contains("ANDROID")) {
            info.setPlatform("android");
        }
        if (ua.contains("IPHONE")) {
            info.setPlatform("ios");
        }
        if (ua.contains("IOS")) {
            info.setPlatform("ios");
        }

            //if (!multiRequest) {
            //    Map<String, Object> params = RequestHelper.getParams(request);
            //    info.setParams(params);
            //    // 转换request
            //    //MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //    //// 获得文件
            //    //Map<String, MultipartFile> fileMap = multiRequest.getFileMap();
            //    //if(fileMap != null && fileMap.size() > 0){
            //    //    params = new HashMap<>();
            //    //    for (Map.Entry<String,MultipartFile> file:fileMap.entrySet()){
            //    //        MultipartFile ff = file.getValue();
            //    //        params.put("fileName",ff.getOriginalFilename());
            //    //        params.put("fileSize",ff.getSize());
            //    //    }
            //    //}
            //}
            return info;
        }

    /**
     * description 取request中的已经被防止XSS，SQL注入过滤过的key value数据封装到map 返回
     *
     * @param request 1
     * @return java.util.Map<java.lang.String,java.lang.String>
     */
    public static Map<String,String> getRequestParameters(ServletRequest request) {
        Map<String,String> dataMap = new HashMap<>(16);
        Enumeration enums = request.getParameterNames();
        while (enums.hasMoreElements()) {
            String paraName = (String)enums.nextElement();
            String paraValue = RequestHelper.getRequest(request).getParameter(paraName);
            if(null!=paraValue && !"".equals(paraValue)) {
                dataMap.put(paraName,paraValue);
            }
        }
        return dataMap;
    }

    /**
     * description 获取request中的body json 数据转化为map
     *
     * @param request 1
     * @return java.util.Map<java.lang.String,java.lang.String>
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> getRequestBodyMap(ServletRequest request) {
        Map<String ,String > dataMap = new HashMap<>(16);
        // 判断是否已经将 inputStream 流中的 body 数据读出放入 attribute
        if (request.getAttribute("body") != null) {
            // 已经读出则返回attribute中的body
            return (Map<String,String>)request.getAttribute("body");
        } else {
            try {
                Map<String, Object> maps = JSON.parseObject(String.valueOf(request.getInputStream()),Map.class);
                maps.forEach((key, value) -> dataMap.put(key, String.valueOf(value)));
                request.setAttribute("body",dataMap);
            }catch (IOException e) {
                e.printStackTrace();
            }
            return dataMap;
        }
    }

    /**
     * description 读取request 已经被防止XSS，SQL注入过滤过的 请求参数key 对应的value
     *
     * @param request 1
     * @param key 2
     * @return java.lang.String
     */
    public static String getParameter(ServletRequest request, String key) {
        return RequestHelper.getRequest(request).getParameter(key);
    }

    /**
     * description 读取request 已经被防止XSS，SQL注入过滤过的 请求头key 对应的value
     *
     * @param request 1
     * @param key 2
     * @return java.lang.String
     */
    public static String getHeader(ServletRequest request, String key) {
        return RequestHelper.getRequest(request).getHeader(key);
    }

    /**
     * description 取request头中的已经被防止XSS，SQL注入过滤过的 key value数据封装到map 返回
     *
     * @param request 1
     * @return java.util.Map<java.lang.String,java.lang.String>
     */
    public static Map<String,String> getRequestHeaders(ServletRequest request) {
        Map<String,String> headerMap = new HashMap<>(16);
        Enumeration enums = RequestHelper.getRequest(request).getHeaderNames();
        while (enums.hasMoreElements()) {
            String name = (String) enums.nextElement();
            String value = RequestHelper.getRequest(request).getHeader(name);
            if (null != value && !"".equals(value)) {
                headerMap.put(name,value);
            }
        }
        return headerMap;
    }

    public static HttpServletRequest getRequest(ServletRequest request) {
        return new XssSqlHttpServletRequestWrapper((HttpServletRequest) request);
    }

    /**
     * description 封装response  统一json返回
     *
     * @param outStr 1
     * @param response 2
     */
    public static void responseWrite(String outStr, ServletResponse response) {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter printWriter;
        try {
            printWriter = WebUtils.toHttp(response).getWriter();
            printWriter.write(outStr);
        }catch (Exception e) {
            log.error(e.getMessage(),e);
        }
    }

    }
