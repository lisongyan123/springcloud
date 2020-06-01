package com.example.cloudservice.common.config;

import org.apache.commons.configuration.*;

public class ColUtil {

    /**
     * 转换mysql数据类型为java数据类型
     * @param type 数据库字段类型
     * @return String
     */
    static String cloToJava(String type){
        Configuration config = getConfig();
        assert config != null;
        return config.getString(type,"unknowType");
    }

    /**
     * 获取配置信息
     */
    public static PropertiesConfiguration getConfig() {
        try {
            return new PropertiesConfiguration("generator.properties" );
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 读取配置文件
     * @param strfile
     * @return
     */
    public static Configuration getConfig(String strfile) {
        Configuration config = null;
        try {
            ConfigurationFactory factory = new ConfigurationFactory(strfile);
//			URL configURL = new File(strfile).toURL();
//			factory.setConfigurationFileName(configURL.toString());
            config = factory.getConfiguration();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return config;
    }
}
