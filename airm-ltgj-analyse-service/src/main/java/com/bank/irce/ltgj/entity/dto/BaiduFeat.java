package com.bank.irce.ltgj.entity.dto;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Slf4j
public class BaiduFeat {

    public static final Integer ZERO = 0;

    /**空则设置默认值*/
    public static String getDefaultValue(Object object) {
        return String.valueOf(Optional.ofNullable(object).orElseGet(() -> String.valueOf(new Integer(-1))));
    }

    /**获取score*/
    public static String getScoreFromBaiduJson(String var1, String var2, String var3, String var4,BaiduInfo baiduInfo){
        String returnValue = null;
        try{
            JSONObject baiduJson = JSONObject.parseObject(var1);
            JSONObject infoJson = JSONObject.parseObject(JSONObject.toJSONString(baiduJson.get(var2)));
            JSONObject produceJson = JSONObject.parseObject(JSONObject.toJSONString(infoJson.get(var3)));
            Integer a = Integer.valueOf(String.valueOf(JSONArray.parseArray(String.valueOf(produceJson.get(var4))).get(ZERO)));
            returnValue = getDefaultValue(a);
        } catch (NullPointerException e) {
            returnValue = "-1";
            log.info("传入字段有报空 ，参数设置默认值-1");
        }
        return returnValue;
    }

    /**获取数据*/
    public static String getDataFromBaiduJson(String var1, String var2, String var3, String var4, BaiduInfo baiduInfo){
        String returnValue = null;
        String resultJson = null;
        try{
            JSONObject baiduJson = JSONObject.parseObject(var1);
            JSONObject infoJson = (JSONObject) baiduJson.get(var2);
            if(!StringUtils.isEmpty(var3)) {
                JSONObject numJson = (JSONObject) infoJson.get(var3);
                resultJson = (String) numJson.get(var4);
            }else{
                resultJson = String.valueOf(infoJson.get(var4));
            }
            returnValue = getDefaultValue(resultJson);
        } catch (Exception e) {
            returnValue = "-1";
            log.info("传入字段有报空 ,参数设置默认值-1");
        }
        return returnValue;
    }
}

