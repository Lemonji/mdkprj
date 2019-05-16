package com.mdkproject.mdk2019.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Base64OutputStream;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Liberal-World
 * @Date: 2019-03-29 11:29
 * @Description:二维码处理工具
 * @Version 1.0
 */
public class QRcodeUtils {
    //base64编码集
    private static final String CHARSET = "UTF-8";
    //二维码高度
    private static final int HEIGHT = 150;
    //二维码宽度
    private static final int WIDTH = 150;
    //二维码外边距
    private static final int MARGIN = 0;
    //二维码图片格式
    private static final String FORMAT = "jpg";
    
    
    
    /**
     * @auther: lizhen
     * @date: 2019-03-29 11:35
     * 功能描述: 生成二维码,字符串二维码实际内容
     */
    public BufferedImage createQRCode(String data){
        return createQRCode(data,WIDTH,HEIGHT, MARGIN);
    }

    /**
     * 生成二维码
     * data:字符串（二维码实际内容）
     * retrun:bufferedImage
     */
    private static BufferedImage createQRCode(String data, int width, int height, int margin) {
        BitMatrix matrix;
        try {
            //设置QR二维码参数
            Map<EncodeHintType,Object> hints = new HashMap<>();
            //纠错级别（H为最高）
            //L级：约可纠错7%的数据码字
            //M级：约可纠错15%的数据码字
            //Q级：约可纠错25%的数据码字
            //H级：约可纠错30%的数据码字
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            //字符集
            hints.put(EncodeHintType.CHARACTER_SET,CHARSET);
            //边框（num*10）
            hints.put(EncodeHintType.MARGIN,0);
            //编码内容，类型，图片宽高，设置参数
            matrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE,width,height,hints);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(),e);
        }
        return MatrixToImageWriter.toBufferedImage(matrix);

    }


    /**
     * 生成带Logo的二维码
     * return bufferedImage
     */
    public BufferedImage createQRCodeWithLogo(String data, File logoFile){
        return createQRCodeWithLogo(data,WIDTH,HEIGHT,MARGIN,logoFile);
    }
    private BufferedImage createQRCodeWithLogo(String data, int width, int height, int margin, File logoFile) {
        BufferedImage combined;
        try {
            //二维码
           BufferedImage qrcode = createQRCode(data,width,height,margin);
           //图片
           BufferedImage logo = ImageIO.read(logoFile);
           int deltaHeight = height - logo.getHeight();
           int deltaWidth = width - logo.getWidth();
           combined = new BufferedImage(height,width,BufferedImage.TYPE_INT_ARGB);


           Graphics2D g = (Graphics2D) combined.getGraphics();
           g.drawImage(qrcode,0,0,null);
           g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f));
           g.drawImage(logo, Math.round(deltaWidth / 2), Math.round(deltaHeight / 2),null);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(),e);
        }
        return combined;
    }


    //返回二维码
    /**
     * 将二维码信息写入文件中
     *  image
     *  file : 用于存储二维码的文件对象
     *  FORMAT : 图片格式
     */
    public void writeToFile(BufferedImage image,File file){
        try {
            if (!file.exists()){
                file.mkdirs();
            }
            boolean result = ImageIO.write(image, FORMAT, file);
            if (result){
                System.out.println("成功");
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage(),e);
        }
    }

    /**
     * 将二维码信息写入流中
     *  image
     *  文件steam
     */
    public static void writeToStream(BufferedImage image, OutputStream stream){
        try {
            boolean result = ImageIO.write(image, FORMAT, stream);
            if (!result){
                System.out.println("失败");
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage(),e);
        }
    }

    /**
     * 获取base64格式的二维码
     * 图片类型jpg
     * 展示<img src="data:image/jpeg;base64,base64Str"/>
     * image
     * base64
     */
    public String writeToString(BufferedImage image){
        String base64Str = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            OutputStream os = new Base64OutputStream(bos);
            writeToStream(image,os);
            //按指定的字符集进行转换并去除换行符
            base64Str = bos.toString(CHARSET).replace("\r\n","");
        }catch (Exception e){
            throw new RuntimeException(e.getMessage(),e);
        }
        return base64Str;
    }

    //base64转图片
    public void base64ToImage(String base64,File file){
        FileOutputStream os;
        try {
            Base64 d = new Base64();
            byte[] bs = d.decode(base64);
            os = new FileOutputStream(file.getAbsolutePath());
            os.write(bs);
            os.close();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage(),e);
        }
    }






    //测试
    public static void main(String[] args) {
        QRcodeUtils q = new QRcodeUtils();
        String data = "www.baidu.com";
        //生成二维码
        BufferedImage bufferedImage = q.createQRCode(data);
        String fileName = "博客园";
        File qrcodeFile = new File("F:/"+fileName+".png");
        q.writeToFile(bufferedImage,qrcodeFile);//写入文件
        System.out.println(q.writeToString(bufferedImage));


    }


}

