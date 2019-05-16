package com.mdkproject.mdk2019.utils;


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

/**
 * @Auther: Liberal-World
 * @Date: 2019-03-25 14:11
 * @Description:
 * @Version 1.0
 */
public class ImgOrBase64 {




    public static String base64StrToImage(String imgStr, String path) {
        if (imgStr == null)
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // 解密
            byte[] b = decoder.decodeBuffer(imgStr);
            // 处理数据
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            //文件夹不存在则自动创建
            File tempFile = new File(path);
            if (!tempFile.getParentFile().exists()) {
                tempFile.getParentFile().mkdirs();
            }
            OutputStream out = new FileOutputStream(tempFile);
            out.write(b);
            out.flush();
            out.close();
            return tempFile.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static String imageToBase64Str(String imgFile) {
        InputStream inputStream = null;
        byte[] data = null;
        try {
            inputStream = new FileInputStream(imgFile);
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 加密
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }

    //测试
    public static void main(String[] args) {
        String strImg = imageToBase64Str("F:/img.png");
        System.out.println(strImg);
        String Path = "F:/img";
        String s = base64StrToImage(strImg, Path);
        System.out.println(s);

    }
}
