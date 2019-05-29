package com.mdkproject.mdk2019.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mdkproject.mdk2019.entity.TbIdcard;
import com.mdkproject.mdk2019.response.CommonReturnType;
import com.mdkproject.mdk2019.services.DeptOrderInfoService;
import com.mdkproject.mdk2019.services.IdCardService;
import com.mdkproject.mdk2019.utils.Base64Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/idcard")
public class IdCardController {
    @Autowired
    private IdCardService idCardService;

    @Autowired
    private DeptOrderInfoService deptOrderInfoService;

    private static final Logger logger = LoggerFactory.getLogger(IdCardController.class);

    /**
     * 每次拿到身份证信息的时候都做一次判断
     * 如果身份证信息已存在，且保存时间超过11个月，那么就允许更新，否则不允许
     * 如果是新的身份证信息那么就直接新增一条数据
     */
    @PostMapping("/insertidcard")
    public CommonReturnType insertsome(@RequestBody Map data) {
        System.out.println("请求道理");
        // 首先把字符串转为json对象
        String jsonstr= JSON.toJSONString(data,true);
        //System.out.println(jsonstr);
        JSONObject jsonObject = JSONObject.parseObject(jsonstr);
        String idCard = jsonObject.getString("idcardnum");      //身份证号
        TbIdcard res = idCardService.selectByIdnum(idCard);
        //System.out.println(res);
        if (res != null) {
            String createtime = res.getCreatetime();
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date createdate = sf.parse(createtime);
                Date nowdate = new Date();
                GregorianCalendar gc = new GregorianCalendar();
                gc.setTime(createdate);
                gc.add(2, 11);
                Date newdate = gc.getTime();
                int dateresult = newdate.compareTo(nowdate);
                if (dateresult > 0) {
                    return CommonReturnType.createCommonReturnType("有效期未满11个月","fail");
                }else {
                    idCardService.deleteByPrimaryKey(res.getHealthNum());
                    res.setHealthNum(0);
                    res.setCreatetime(sf.format(nowdate));
                    int updateres=idCardService.insert(res);
                    if(updateres!=0){
                        return CommonReturnType.createCommonReturnType("上传成功","fail");
                    }else {
                        return CommonReturnType.createCommonReturnType("未知错误，上传失败","fail");
                    }
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        String path = "C:\\img\\" + jsonObject.getString("idcardnum") + ".jpg";
        //将图片存储到本地并转换photo的值为图片路径
        if (jsonObject.getString("photo") != null) {
            String basestr = jsonObject.getString("photo");
            Base64Util.GenerateImage(basestr, path);
            jsonObject.put("photo", path);
        }
        int jssize = 0;
        for (String key : jsonObject.keySet()) {
            jssize++;
            if (jsonObject.get(key) == null
                    || jsonObject.get(key) == ""
                    || jsonObject.get(key).equals("")
                    || jsonObject.get(key).toString().trim().length() == 0) {
                logger.info("出现了空字符串");
                jssize--;
            }
            System.out.println(jssize);
        }
        if (jssize < 10) {
            return CommonReturnType.createCommonReturnType("参数有误","fail");
        }
        Pattern pattern =
                Pattern.compile("^(\\d{6})(18|19|20)?(\\d{2})([01]\\d)([0123]\\d)(\\d{3})(\\d|X|x)?$");
        String idcardnum = jsonObject.getString("idcardnum");
        Matcher matcher = pattern.matcher(idcardnum);
        if (!matcher.matches()) {
            return CommonReturnType.createCommonReturnType("身份证格式有误","fail");
        }

        //添加其他两个不需要传参的字段
        jsonObject.put("healthNum", 0);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        jsonObject.put("createtime", df.format(new Date()));

        // 直接将json对象转为java对象
        TbIdcard tbIdcard = jsonObject.toJavaObject(TbIdcard.class);
        int result = idCardService.insert(tbIdcard);

        //更新信息
//        logger.info(path);
//        boolean b = deptOrderInfoService.updateByIdCard(idCard, path);
//        if (b){
//            logger.info("补全照片成功");
//        }else{
//            logger.info("补全信息失败");
//        }

        if (result != 0) {
            return CommonReturnType.createCommonReturnType("上传成功");
        }
        return CommonReturnType.createCommonReturnType("未知错误，上传失败","fail");
    }












    @GetMapping("/test")
    public String test() {
        System.out.println("连接成功");
        return "连接成功";
    }
}
