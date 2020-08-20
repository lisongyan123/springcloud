package com.bank.irce.ltgj.common;

import com.alibaba.fastjson.JSONObject;
import com.bank.irce.ltgj.entity.dto.Constant;
import com.bank.irce.ltgj.entity.dto.ValidateConstant;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class SimpleEncapsulationUtil {

    private static String regex;

    private static String valueType;

    public synchronized static Object iteratorAttrByType(Map source, String valueType, String... args) {
        SimpleEncapsulationUtil.valueType=valueType;
        Object result = iteratorAttrByTypeAndRegex(source, valueType, null, args);
        SimpleEncapsulationUtil.valueType=null;
        return result;
    }

    /**
     * @param valueType 1 int 2 string 3 date 4 Map 5 List
     *                  regex 校验正则
     */

    public synchronized static Object iteratorAttrByTypeAndRegex(Map source, String valueType, String regex, String... args) {
        SimpleEncapsulationUtil.regex = regex;
        SimpleEncapsulationUtil.valueType=valueType;
        Object defaultValue;
        switch (valueType) {
            case "1":
                defaultValue = ValidateConstant.VALUE_TYPE_INT_DEFAULT_VALUE;
                break;
            case "2":
                defaultValue = ValidateConstant.VALUE_TYPE_STRING_DEFAULT_VALUE;
                break;
            case "3":
                defaultValue = ValidateConstant.VALUE_TYPE_DATE_DEFAULT_VALUE;
                break;
            case "4":
                defaultValue = new HashMap<>();
                break;
            case "5":
                defaultValue = new ArrayList();
                break;
            default:
                defaultValue = "";
        }
        Object value = iteratorAttr(source, defaultValue, args);
        SimpleEncapsulationUtil.regex = null;
        SimpleEncapsulationUtil.valueType=null;
        return value;
    }

    public synchronized static Object iteratorAttrByRegex(Map source,Object defaultValue,String regex, String... args) {
        SimpleEncapsulationUtil.regex = regex;
        Object value = iteratorAttr(source, defaultValue, args);
        SimpleEncapsulationUtil.regex = null;
        return value;
    }

    public static Object iteratorAttr(Map source, Object defaultValue, String... args) {
        try {
            Object result = null;
            Map tempSource = source;
            for (int i = 0; i < args.length; i++) {
                if (i != args.length - 1) {
                    tempSource = (Map) tempSource.get(args[i]);
                } else {
                    result = tempSource.get(args[i]);
                }
            }
            //如果没有获取到值返回默认值
            if (StringUtils.isEmpty(result)) {
                return defaultValue;
            }
            //如果获取到的值与原类型不符则返回默认值
            if (!contrastAttributeType(result, defaultValue)) {
                return defaultValue;
            }
            return result;
        } catch (Exception e) {
            //e.printStackTrace();
            //e.printStackTrace();
            //发生异常返回默认值
            return defaultValue;

        }
    }

    private static boolean contrastAttributeType(Object result, Object defaultValue) {
        //int 类型校验
        if (defaultValue instanceof Integer || (!StringUtils.isEmpty(defaultValue) && Pattern.compile(Constant.IS_INT).matcher(defaultValue.toString()).matches())) {
            if (!Pattern.compile(Constant.IS_INT).matcher(result.toString()).matches()) {
                return false;
            }
        }
        //map 类型校验
        if (defaultValue instanceof Map && !(result instanceof Map)) {
            return false;
        }
        //List 类型校验
        if (defaultValue instanceof List && !(result instanceof List)) {
            //ParameterizedType pt = (ParameterizedType)defaultValue.getClass().getGenericSuperclass();
            //String typeName =pt.getActualTypeArguments()[0].getTypeName();
            //if(result.getClass().getTypeName().equals(typeName)){
            ((List) defaultValue).add(result);
            //}
            return false;
        }
       /* if(defaultValue instanceof List && result instanceof List){
            ParameterizedType pt = (ParameterizedType)defaultValue.getClass().getGenericSuperclass();
            ParameterizedType pt2 = (ParameterizedType)result.getClass().getGenericSuperclass();
            System.out.println(pt.getActualTypeArguments()[0].getTypeName());
            System.out.println(pt2.getActualTypeArguments()[0].getTypeName());

            if(!pt.getActualTypeArguments()[0].getTypeName().equals(pt2.getActualTypeArguments()[0].getTypeName())){
                return false;
            }
        }*/
        //通用校验
        if (!(StringUtils.isEmpty(regex) || Pattern.compile(regex).matcher(result.toString()).matches())) {
            return false;
        }
        //时间类型特殊处理
        if(ValidateConstant.VALUE_TYPE_DATE.equals(valueType) && result.toString().length()>10){
            result = result.toString().substring(0,10);
        }
        return true;
    }


    public static Object iteratorAttrStr(JSONObject source, String arg1, String arg2, String arg3) {

        Object obj = source.getJSONObject(arg1).getJSONObject(arg2).getOrDefault(arg3, "NaN");

        return obj;
    }

    public static Object iteratorAttrInt(JSONObject source, String arg1, String arg2) {

        Object obj = source.getJSONObject(arg1).getOrDefault(arg2, "0");

        return obj;
    }


    public static Object iteratorAttrInt(JSONObject source, String arg1, String arg2, String arg3, String arg4) {

        Object obj = source.getJSONObject(arg1).getJSONObject(arg2).getJSONObject(arg3).getOrDefault(arg4, "0");

        return obj;
    }


}
