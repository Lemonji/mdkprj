package com.mdkproject.mdk2019.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class SimpledateUtil {

    public static String getSimpledate(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        String createtime=sdf.format(date);
        return createtime;
    }

    public static String getMonth(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
        Date date=new Date();
        String createtime=sdf.format(date);
        return createtime;
    }

    public static String getLastWeek(){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        GregorianCalendar gc=new GregorianCalendar();
        gc.setTime(date);
        gc.add(3,-1);
        Date lastweek=gc.getTime();
        String sf=sdf.format(lastweek);
        return sf;
    }
}
