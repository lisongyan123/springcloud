package com.bank.irce.ltgj.common;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesUtil {

    public static Properties max;

    public static Properties min;

    public static Properties mean;

    public static Properties modelInfo;

    static {
        max = getValue("max");
        min = getValue("min");
        mean = getValue("mean");
        modelInfo = getValue("application.properties");
    }

    public static Properties getValue(String fileName) {
        Properties properties = null;
        try {
            Resource resource = new ClassPathResource(fileName);
            properties = PropertiesLoaderUtils.loadAllProperties(fileName);
            InputStream is = resource.getInputStream();
            BufferedReader bf = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            properties.load(bf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }


    public static Properties readPropertiesFile(String fileName) {
        try {
            Resource resource = new ClassPathResource(fileName);
            Properties props = PropertiesLoaderUtils.loadProperties(resource);
            return props;
        } catch (Exception e) {
            System.out.println("————读取配置文件：" + fileName + "出现异常，读取失败————");
            e.printStackTrace();
        }
        return null;
    }

}
