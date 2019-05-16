package com.mdkproject.mdk2019.test;

import com.sun.jna.Library;
import com.sun.jna.Native;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Liberal-World
 * @Date: 2019-04-25 16:24
 * @Description: 身份证阅读
 * @Version 1.0
 */
public class CardTest {

    private final static Logger logger = LoggerFactory.getLogger(CardTest.class);

    private byte[] BaseMsgData = new byte[100];


    // 使用jna
    public interface hcicrf extends Library {
        //连接读卡器
        int HD_InitComm(int port);

        //断开连接
        int HD_CloseComm(int stop);

        //卡认证
        int HD_Authenticate(int iType);

        //身份证原始数据 文字+照片
        int HD_Read_IDInfo(String pBmpData, byte[] BaseMsgData);
    }



    public void getInfo(){
        //加载dll文件
        hcicrf open = (hcicrf) Native.loadLibrary("HDstdapi_x64", hcicrf.class);
        if (open!=null){
            logger.info("dll加载成功");


            //链接读卡器
            int icdev = open.HD_InitComm(1001);
            Map<String, Object> map = new HashMap<>();

            if (icdev == 0){
                logger.info("连接读卡器成功");


                //卡认证.参数1连续读卡，0一次一次读卡
                System.err.println("连续读卡----------->" + open.HD_Authenticate(1));
                //图片随机数
                int a = (int) ((Math.random() * 9 + 1) * 100000);
                String pBmpFile = "D:\\img\\" + a + ".bmp";         //照片

                open.HD_Read_IDInfo(pBmpFile,BaseMsgData);


                try {


                    String data = new String(BaseMsgData, "GBK");

                    logger.info(data);

                    map.put("data",data);


                    logger.info("读取成功");


                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    logger.info("读取失败");
                }


            }

        }

    }

    public static void main(String[] args) {
        CardTest ct = new CardTest();
        ct.getInfo();
    }

}
