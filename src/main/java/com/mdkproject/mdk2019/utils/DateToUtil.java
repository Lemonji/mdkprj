package com.mdkproject.mdk2019.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Auther: Liberal-World
 * @Date: 2019-04-11 16:41
 * @Description: 日期转换工具
 * @Version 1.0
 */
public class DateToUtil {

    //格式转换 19981205---1998-12-05
    public static String datetoStr(String datestr){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date date = null;
        try {
            date = format.parse(datestr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        return format1.format(date);
    }



    //那么如何处理000001自增1变为000002,顺延数
    //%nd 输出的整型宽度至少为n位，右对齐，%5d即宽度至少为5位，位数大于5则输出实际位数
    //%0nd 用得比较多，表示输出的整型宽度至少为n位，不足n位用0填充
    //printf（"%05d",1）输出：00001
    //printf（"%5d",1）输出：****1（*为空格）
    //6位
    public static  String getNewEquipmentNo6(String autonumber){
        //初始值
        String newEquipmentNo = "000001";
        if (autonumber != null && !autonumber.isEmpty()) {
            int newEquipment = Integer.parseInt(autonumber)+1;
            newEquipmentNo = String.format("%06d",newEquipment);
        }
        return newEquipmentNo;
    }
    //5位
    public static  String getNewEquipmentNo5(String autonumber){
        //初始值
        String newEquipmentNo = "00001";
        if (autonumber != null && !autonumber.isEmpty()) {
            int newEquipment = Integer.parseInt(autonumber)+1;
            newEquipmentNo = String.format("%05d",newEquipment);
        }
        return newEquipmentNo;
    }
    //7位
    public static  String getNewEquipmentNo7(String autonumber){
        //初始值
        String newEquipmentNo = "0000001";
        if (autonumber != null && !autonumber.isEmpty()) {
            int newEquipment = Integer.parseInt(autonumber)+1;
            newEquipmentNo = String.format("%07d",newEquipment);
        }
        return newEquipmentNo;
    }

    //获取年月
    public static String getYearMonth(){
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyMM");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    //获取现在时间（yyyy-MM-dd）
    public static String getStringDateShort(){
        Date currentTime = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = format.format(currentTime);
        return dateString;
    }
    //Java计算两个字符串日期之间的天数差（yyy-MM-dd）

    /**
     * a 当前时间
     * b 创建时间
     */
    public static Long between_days(String a, String b) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");// 自定义时间格式

        Calendar calendar_a = Calendar.getInstance();// 获取日历对象
        Calendar calendar_b = Calendar.getInstance();

        Date date_a = null;
        Date date_b = null;

        try {
            date_a = simpleDateFormat.parse(a);//字符串转Date
            date_b = simpleDateFormat.parse(b);
            calendar_a.setTime(date_a);// 设置日历
            calendar_b.setTime(date_b);
        } catch (ParseException e) {
            e.printStackTrace();//格式化异常
        }

        long time_a = calendar_a.getTimeInMillis();
        long time_b = calendar_b.getTimeInMillis();

        long between_days = (time_b - time_a) / (1000 * 3600 * 24);//计算相差天数

        return between_days;
    }












    //测试
    public static void main(String[] args) {



        String equipmentNo = DateToUtil.getNewEquipmentNo6("1");
        System.out.println("生成设备编号：" + equipmentNo);
        System.out.println(getYearMonth());
    }


}
