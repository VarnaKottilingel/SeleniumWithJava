package com.github.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigurationUtils {
    private Properties properties;
    private static Map<String, String> configMap = new HashMap<>();

    public ConfigurationUtils(String filePath) {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            properties.load(fileInputStream);
            // Load properties into configMap
            for (String key : properties.stringPropertyNames()) {
                configMap.put(key, properties.getProperty(key));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static void setValue(String key, String value) {
        configMap.put(key, value);
    }

    public static String getValue(String key) {
        return configMap.get(key);
    }

    public String getUrl() {
        return properties.getProperty("url");
    }
}


