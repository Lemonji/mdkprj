package com.mdkproject.mdk2019.utils;

import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Auther: Liberal-World
 * @Date: 2019-04-01 17:10
 * @Description:获取工程目录下Properties文件key的值
 * @Version 1.0
 */
public class GetProperties {
    public static String getpro(String filePath,String key){
        Properties properties = new Properties();
        String value;
        try {
            //加载输入流
            properties.load(asStream(filePath));
            //根据key获取value
            value = properties.getProperty(key);

            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static InputStream asStream(String resourceName) throws IOException {
        return Resources.getResourceAsStream(resourceName);
    }

    public static void main(String[] args) {
        System.err.println(getpro("my.properties", "imgpath"));
        System.err.println(getpro("my.properties", "filepath"));
        System.err.println(getpro("my.properties", "urlpath"));
    }


}
