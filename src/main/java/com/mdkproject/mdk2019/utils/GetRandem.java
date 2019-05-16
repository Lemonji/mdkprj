package com.mdkproject.mdk2019.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetRandem {
	
	public static String getDateR(){
		double rd = Math.random()*1000000;
		int rds = (int)rd;
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return format.format(date)+rds;
	}
	
	public static String getR(){
		double rd = Math.random()*1000000;
		int rds = (int)rd;
		return rds+"";
	}
	
	public static String getTime() {
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}

}