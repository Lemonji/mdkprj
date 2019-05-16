package com.mdkproject.mdk2019.controller;

import com.mdkproject.mdk2019.error.BusinessException;
import com.mdkproject.mdk2019.error.EmBusinessError;
import com.mdkproject.mdk2019.utils.Base64Util;
import com.mdkproject.mdk2019.utils.BmptoJPG;
import com.mdkproject.mdk2019.utils.DateToUtil;
import com.mdkproject.mdk2019.utils.ReadCardUtil;
import com.sun.jna.Library;
import com.sun.jna.Native;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/** @Date: 2019-04-01 14:48 @Description:身份证信息读取模块 @Version 1.0 */
@Controller
@RequestMapping("/card")
@CrossOrigin(origins = "*", allowCredentials = "true")
public class ReadCardController extends BaseController {

  Logger logger = LoggerFactory.getLogger(ReadCardController.class);

  @Autowired private StringRedisTemplate stringRedisTemplate;

  // 参数
  private byte[] pName = new byte[100]; // 姓名
  private byte[] pSex = new byte[100]; // 性别
  private byte[] pNation = new byte[100]; // 民族
  private byte[] pBirth = new byte[100]; // 出生日期
  private byte[] pCertNo = new byte[100]; // 身份证号
  private byte[] pDepartment = new byte[100]; // 签发机关
  private byte[] pEffectDate = new byte[100]; // 有效起始日期
  private byte[] pExpire = new byte[100]; // 有效截止日期
  private byte[] pAddress = new byte[100]; // 住址

  private byte[] fpInfo = new byte[100]; // 指纹数据

  private byte[] pEnName = new byte[100]; // 外国人英文名
  private byte[] pNationalityCode = new byte[100]; // 外国人国籍代码，符合GB/T2659-2000规定

  private byte[] pTXZHM = new byte[100]; // 港澳台通行证号码
  private byte[] pTXZQFCS = new byte[100]; // 港澳台通行证签发次数

  // C语言对应的jna参数
  //    private IntByReference port = new IntByReference(1001);   //端口1001
  //    private IntByReference iType = new IntByReference(1);     //参数1连续读卡，0一次一次读卡
  //    private IntByReference stop = new IntByReference(1001);     //参数1连续读卡，0一次一次读卡

  // 健康证编号
  private int count = 0;

  // 使用jna
  public interface hcicrf extends Library {
    // 连接读卡器
    int HD_InitComm(int port);

    // 断开连接
    int HD_CloseComm(int stop);

    // 卡认证
    int HD_Authenticate(int iType);

    // 读卡信息（港澳台）
    int HD_ReadCard();

    // 证件类型
    int GetCardType();

    // 获取身份证信息
    int HD_Read_BaseMsg(
        String pBmpFile,
        byte[] pName,
        byte[] pSex,
        byte[] pNation,
        byte[] pBirth,
        byte[] pAddress,
        byte[] pCertNo,
        byte[] pDepartment,
        byte[] pEffectData,
        byte[] pExpire);

    // 生成照片
    int GetBmpFile(String pBmpfilepath);

    // 是否存在指纹
    int IsFingerExist();

    // 获取指纹数据
    int GetFingerprint(byte[] fpInfo);

    // 外国人永久居留证
    int GetEnName(byte[] pGetEnName); // 外国人英文姓名

    int GetNationalityCode(byte[] pGetNationalityCode); // 外国人国籍代码

    // 港澳台通行证
    int GetTXZHM(byte[] pGetTXZHM); // 港澳台通行证号码

    int GetTXZQFCS(byte[] pGetTXZQFCS); // 港澳台通行证签发次数
  }

  /** @date: 2019-03-22 17:44 功能描述: 身份证信息读取接口 */
  @ResponseBody
  @RequestMapping(
      value = "/get",
      method = {RequestMethod.GET})
  public Map getcard() throws BusinessException {
    // 先加载dll动态库
    hcicrf epen = (hcicrf) Native.loadLibrary("HDstdapi_x64", hcicrf.class);
    if (epen != null) {
      System.out.println("DLL加载成功！");
      try {
        // 链接读卡器
        int icdev = epen.HD_InitComm(1001);
        logger.info("连接信息----" + icdev);
        Map<String, Object> map = new HashMap<>();
        if (icdev == 0) {
          System.err.println("接入成功");

          // 卡认证.参数1连续读卡，0一次一次读卡
          System.err.println("连续读卡----------->" + epen.HD_Authenticate(1));

          // 读卡上信息
          System.err.println("读卡信息----------->" + epen.HD_ReadCard());
          // 获取证件类型
          // 0：居民身份证
          // 1：外国人永久居留证
          // 2：港澳台居民居住证
          int i = epen.GetCardType();

          if (i == 0) {
            // 图片随机数
            int a = (int) ((Math.random() * 9 + 1) * 100000);
            String pBmpFile = "D:\\img\\" + a + ".bmp"; // 照片
            int ret =
                epen.HD_Read_BaseMsg(
                    pBmpFile,
                    pName,
                    pSex,
                    pNation,
                    pBirth,
                    pAddress,
                    pCertNo,
                    pDepartment,
                    pEffectDate,
                    pExpire);

            String pName1 = new String(pName, "GBK");
            String pSex1 = new String(pSex, "GBK");
            String pNation1 = new String(pNation, "GBK");
            String pBirth1 = new String(pBirth, "GBK");
            String pAddress1 = new String(pAddress, "GBK");
            String pCertNo1 = new String(pCertNo, "GBK");
            String pDepartmentnew1 = new String(pDepartment, "GBK");
            String pEffectDate1 = new String(pEffectDate, "GBK");
            String pExpire1 = new String(pExpire, "GBK");

            map.put("cardType", ret);
            map.put("pName", pName1.trim());
            map.put("pSex", pSex1.trim());
            map.put("pNation", pNation1.trim());
            map.put("pBirth", datetoStr(pBirth1.trim()));
            map.put("pAddress", pAddress1.trim());
            map.put("pCertNo", pCertNo1.trim());
            map.put("pDepartment", pDepartmentnew1.trim());
            map.put("pEffectDate", pEffectDate1.trim());
            map.put("pExpire", pExpire1.trim());
            // 生成图片
            int b = epen.GetBmpFile(pBmpFile);
            System.out.println("身份证照片：--------" + b);
            if (b == 0) {
              System.out.println(pBmpFile);
              String imgPath1 = pBmpFile; // 生成bmp图片地址
              String imgPath2 = "F://jpgimg.jpg"; // 生成jpg图片地址
              // bmp转jpg格式
              BmptoJPG.bmpTojpg(imgPath1, imgPath2);

              // 图片转base64
              String imgpath = "F://jpgimg.jpg";
              //                        String imageStr = ImgOrBase64.imageToBase64Str(imgpath);
              String imageStr = Base64Util.encodeFile(imgpath);
              map.put("imgUrl", imageStr);
              System.err.println("生成照片成功");
            } else {
              System.err.println("生成照片失败");
              throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "读取照片失败");
            }
            //                    //是否存在指纹存在时返回512或者1024,不存在时返回0
            //                    map.put("zw_num", epen.IsFingerExist());
            //                    //获取指纹数据
            //                    map.put("zw_data", epen.GetFingerprint(fpInfo));

            // 编号
            String number = stringRedisTemplate.opsForValue().get("number");
            String numb = DateToUtil.getNewEquipmentNo7(number);
            map.put("num", numb);

            // 健康证编号
            String yearMonth = DateToUtil.getYearMonth();
            String num = DateToUtil.getNewEquipmentNo6(number);
            map.put("hearthcardNum", yearMonth + num);
            int i1 = count++;
            System.out.println(i1);
            stringRedisTemplate.opsForValue().set("number", String.valueOf(i1));
            return map;
          }

          // 1：外国人永久居留证
          if (i == 1) {
            map.put("pEnName", epen.GetEnName(pEnName));
            map.put("pNationalityCode", epen.GetNationalityCode(pNationalityCode));
            return map;
          }
          // 2：港澳台居民居住证
          if (i == 2) {
            map.put("pTXZHM", epen.GetTXZHM(pTXZHM));
            map.put("pTXZQFCS", epen.GetTXZQFCS(pTXZQFCS));
            return map;
          }
        } else {
          System.err.println("连接失败");
        }
        return map;
      } catch (Exception e) {
        e.printStackTrace();
        return null;
      }

    } else {
      System.out.println("DLL加载失败！");
      return null;
    }
  }
  // 格式转换 19981205---1998-12-05
  private static String datetoStr(String datestr) throws ParseException {
    SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
    Date date = format.parse(datestr);
    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
    return format1.format(date);
  }


  @GetMapping("/getimg")
   public void getimg(){
      try {
          new ReadCardUtil().getcard();
      } catch (BusinessException e) {
          e.printStackTrace();
      }
  }
  
}
