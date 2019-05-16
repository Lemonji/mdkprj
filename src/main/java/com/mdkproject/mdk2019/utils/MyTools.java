package com.mdkproject.mdk2019.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Auther: Liberal-World
 * @Date: 2019-03-30 15:21
 * @Description:时间工具类
 * @Version 1.0
 */
public class MyTools {
    //时间+随机数
    public static String getDateR(){
        double rd = Math.random()*1000000;
        int rds = (int)rd;
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return format.format(date)+rds;
    }
    //随机数
    public static String getR(){
        double rd = Math.random()*1000000;
        int rds = (int)rd;
        return rds+"";
    }
    //当前时间
    public static String getTime(){
        Date date = new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    /**
     * 将json字符串转为Map结构
     * 如果json复杂，结果可能是map嵌套map
     * @param jsonStr 入参，json格式字符串
     * @return 返回一个map
     */
    public static Map<String, Object> json2Map(String jsonStr) {
        Map<String, Object> map = new HashMap<>();
        if(jsonStr != null && !"".equals(jsonStr)){
            //最外层解析
            JSONObject json = JSONObject.fromObject(jsonStr);
            for (Object k : json.keySet()) {
                Object v = json.get(k);
                //如果内层还是数组的话，继续解析
                if (v instanceof JSONArray) {
                    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
                    Iterator<JSONObject> it = ((JSONArray) v).iterator();
                    while (it.hasNext()) {
                        JSONObject json2 = it.next();
                        list.add(json2Map(json2.toString()));
                    }
                    map.put(k.toString(), list);
                } else {
                    map.put(k.toString(), v);
                }
            }
            return map;
        }else{
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(getDateR());
        System.out.println(getR());
        System.out.println(getTime());
        String str = "{\"STATUS\":\"1\"}";
        System.out.println(json2Map(str));
    }



}
