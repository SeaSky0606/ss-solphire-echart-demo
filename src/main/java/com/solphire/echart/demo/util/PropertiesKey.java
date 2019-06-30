package com.solphire.echart.demo.util;

import java.util.Properties;

public class PropertiesKey {

    public static Properties properties = new Properties();
    
    static {
        reloadProperties();
    }


    /**
     * 重新加载配置文件
     */
    public static void reloadProperties() {
        try {
            properties.load(PropertiesKey.class.getClassLoader().getResourceAsStream("qq-conf.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取已经加载的值
     *
     * @param key
     * @return
     */
    public static String readValue(String key) {
        return properties.getProperty(key);
    }

    public static String readValue(int key) {
        return properties.getProperty(key + "");
    }


}
