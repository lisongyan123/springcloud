package com.bank.irce.ltgj.common;

import com.alibaba.fastjson.JSONObject;
import com.bank.irce.ltgj.annotation.Mapping2One;
import com.bank.irce.ltgj.entity.dto.CreditMappingResVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

@Slf4j
public class MappingUtil {

    /**
     * 根据映射规则对jsonObject中的属性进行映射
     */
    public static  void  mapping(JSONObject jsonObject, String []mappingProperties, String [] values){
        //mappingProperty 示例 test.test1.test2,要求value必须与mappingProperties一一对应
        for (int i =0; i<mappingProperties.length; i++) {
            String value = values[i];
            String[] propertyArr = mappingProperties[i].split("\\.");
            //定义需要进行赋值的对象
            JSONObject assObj = jsonObject;
            for (int j=0; j<propertyArr.length; j++) {
                if(j==propertyArr.length-1){
                    assObj.put(propertyArr[j],value);
                }else {
                    assObj = (JSONObject) assObj.get(propertyArr[j]);
                }
            }
        }
    }

    public static  void  mappingObjectToMap(CreditMappingResVo creditMappingResVo, JSONObject jsonObject) throws Exception{
        Field[] declaredFields = creditMappingResVo.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Mapping2One annotation = declaredField.getDeclaredAnnotation(Mapping2One.class);
            if(annotation == null){
                continue;
            }
            String value = annotation.value();
            String[] propertyArr = value.split("\\.");
            //定义需要进行赋值的对象
            Map assObj = jsonObject;
            for (int j=0; j<propertyArr.length; j++) {
                if(j==propertyArr.length-1){
                    assObj.put(propertyArr[j],declaredField.get(creditMappingResVo));
                }else {
                    assObj = (Map) assObj.get(propertyArr[j]);
                }
            }
        }
    }

    public static JSONObject  getOneJSonObject() throws IOException {
        ClassPathResource cpr = new ClassPathResource("xml/zhengxin-mapping.xml");
        //InputStream inputStream = this.getClass().getResourceAsStream("xml/zhengxin-mapping.xml");
        String str = Xml2JsonUtil.inputStreamToStr(cpr.getInputStream());
        JSONObject json = Xml2JsonUtil.xml2JSON(str);
        return json;
    }



}
