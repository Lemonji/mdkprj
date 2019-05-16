package com.mdkproject.mdk2019.utils;

import ViKey.ViKeyJavaObj;

import javax.servlet.ServletContextEvent;
import java.lang.reflect.Field;

/**
 * @Auther: Liberal-World
 * @Date: 2019-04-10 11:59
 * @Description: 加密狗工具类
 * @Version 1.0
 */
public class VikeyUtil {

    public static int[] viKeyCount;
    public static ViKeyJavaObj javaObjViKey;
    public static long idveKey;
    public static int[] hID;

    public static int GET_BYCOUNT = -1;         //返回读取ViKey失败
    public static int GET_BYBIGCOUNT = 2;       //返回插入ViKey过多
    public static int GET_BYHID = 0;            //返回读取硬件ID失败



    /*----成功会直接返回硬件ID----*/
    public static void setDataKey(){
        viKeyCount = new int[1];    //获取插入ViKey数量
        hID = new int[1];           //获取硬件ID（序列号）,[最大限额允许*1*个ViKey插入]
        //vikeyAdmin = new byte[]{0x30,0x30,0x30,0x30,0x30,0x30,0x30,0x30,0x00};//管理员登录
        //string = "www.1mava.cn0"; //插入ViKey自动打开网址
    }

    //调用封装Java文件调用dll文件接口获得ViKey的反馈
    public static int getViKeyByID() {
        setDataKey();
        //调用封装好的java文件，包含dll文件的重定义方法以及loadLibrary使用
        javaObjViKey = new ViKeyJavaObj();

        //识别ViKey是否接入,以及接入的数量
        idveKey = javaObjViKey.ViKeyFind(viKeyCount);
        if (idveKey == javaObjViKey.VIKEY_SUCCESS) {
            System.out.println("系统检测ViKey成功，Count = " + viKeyCount[0]);
            if (viKeyCount[0]>hID.length){
                //提示用户插入ViKey的最大值
                System.out.println("插入ViKey数量过多");
                return GET_BYBIGCOUNT;
            }

            //获取ViKey序列号--唯一的硬件ID
            idveKey = javaObjViKey.ViKeyGetHID((short) 0,hID);
            if (idveKey == javaObjViKey.VIKEY_SUCCESS) {
                System.out.println("ViKey_ID = "+hID[0]);
                return hID[0];
            }else {
                System.out.println("ViKey_ID读取失败");
                return GET_BYHID;
            }
        } else {
            System.out.println("系统没有检测出ViKey!!!");
            return GET_BYCOUNT;
        }
    }

    private void addDirToPath(String s){
        try {
            //获取系统path变量对象
            Field field=ClassLoader.class.getDeclaredField("sys_paths");
            //设置此变量对象可访问
            field.setAccessible(true);
            //获取此变量对象的值
            String[] path=(String[])field.get(null);
            //创建字符串数组，在原来的数组长度上增加一个，用于存放增加的目录
            String[] tem=new String[path.length+1];
            //将原来的path变量复制到tem中
            System.arraycopy(path,0,tem,0,path.length);
            //将增加的目录存入新的变量数组中
            tem[path.length]=s;
            //将增加目录后的数组赋给path变量对象
            field.set(null,tem);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void contextInitialized(ServletContextEvent arg0) {
        //获取存放dll文件的绝对路径（假设将dll文件放在系统根目录下的WEB-INF文件夹中）
        String path=arg0.getServletContext().getRealPath("WEB-INF");
        //将此目录添加到系统环境变量中
        addDirToPath(path);
        //加载相应的dll文件，注意要将'\'替换为'/'
        System.load(path.replaceAll("\\\\","/")+"/XXXX.dll");
    }


    public static void main(String[] args) {
//        int viKeyByID = VikeyUtil.getViKeyByID();
//
//        if (viKeyByID== -1){
//            System.out.println("系统没有检测出ViKey!!!");
//        }
//        System.out.println(viKeyByID);



        System.out.println(System.getProperty("java.library.path"));
    }


}
