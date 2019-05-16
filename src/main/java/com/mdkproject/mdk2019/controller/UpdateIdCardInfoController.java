package com.mdkproject.mdk2019.controller;

import com.mdkproject.mdk2019.entity.TbIdcard;
import com.mdkproject.mdk2019.error.BusinessException;
import com.mdkproject.mdk2019.error.EmBusinessError;
import com.mdkproject.mdk2019.response.CommonReturnType;
import com.mdkproject.mdk2019.services.IdCardService;
import com.mdkproject.mdk2019.utils.Base64Util;
import com.mdkproject.mdk2019.utils.DateToUtil;
import com.mdkproject.mdk2019.utils.MyTools;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Liberal-World
 * @Date: 2019-04-28 09:45
 * @Description:  身份证信息补全更新
 * @Version 1.0
 */

@Controller
@RequestMapping("updateinfo")
public class UpdateIdCardInfoController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(UpdateIdCardInfoController.class);

    @Autowired
    private IdCardService idCardService;


    /**
     * 身份证信息录入
     * 批量
     */
    @RequestMapping(value = "updateall", method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType updateall(Map<String, Object> map) throws BusinessException {
        List<TbIdcard> list = new ArrayList<>();        //插入集合
        List<TbIdcard> list2 = new ArrayList<>();       //更新集合
        JSONArray jsonArray = JSONArray.fromObject(map);
        System.out.println(jsonArray.size());
        for (int i =0;i<jsonArray.size();i++){
            TbIdcard cardinfo = new TbIdcard();
            JSONObject json = JSONObject.fromObject(jsonArray.get(i));
            //判断是否已录入，是否满一年
            TbIdcard card = idCardService.selectByIdnum(json.getString("idCard"));//获取对象
            if (card!=null){
                String createtime = card.getCreatetime().substring(0,10);           //获取创建时间yyyy-MM-dd
                String dateShort = DateToUtil.getStringDateShort();                 //获取现在时间yyyy-MM-dd
                Long moreDate = DateToUtil.between_days(dateShort, createtime);     //当前时间-创建时间>1年
                System.out.println(moreDate);
                if (moreDate<365){
                    throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"信息还在有限期1年内");
                }else{
                    //大于一年更新
                    card.setName(json.getString("name"));
                    String idcard = json.getString("idcard");
                    card.setIdcardNum(idcard);
                    card.setAge(Integer.valueOf(json.getString("age")));
                    card.setSex(json.getString("sex"));
                    card.setNation(json.getString("nation"));
                    //照片处理
                    String photo = json.getString("photo");
                    String path = "C:/"+idcard+".jpg";
                    Base64Util.GenerateImage(photo,path);
                    card.setPhoto(path);
                    card.setStarttime(DateToUtil.datetoStr(json.getString("starttime")));
                    card.setEndtime(DateToUtil.datetoStr(json.getString("endtime")));
                    card.setAddress(json.getString("address"));
                    card.setPsb(json.getString("pab"));
                    card.setCreatetime(MyTools.getTime());
                    //要更新的集合
                    list2.add(card);
                }
            }else if (card==null){
                cardinfo.setName(json.getString("name"));                       //姓名
                String idcard = json.getString("idcard");
                cardinfo.setIdcardNum(idcard);
                cardinfo.setAge(Integer.valueOf(json.getString("age")));
                cardinfo.setSex(json.getString("sex"));
                cardinfo.setNation(json.getString("nation"));
                //照片处理
                String photo = json.getString("photo");
                String path = "C:/"+idcard+".jpg";
                Base64Util.GenerateImage(photo,path);
                card.setPhoto(path);
                cardinfo.setStarttime(DateToUtil.datetoStr(json.getString("starttime")));
                cardinfo.setEndtime(DateToUtil.datetoStr(json.getString("endtime")));
                cardinfo.setAddress(json.getString("address"));
                cardinfo.setPsb(json.getString("pab"));
                cardinfo.setCreatetime(MyTools.getTime());
                //要新增的集合
                list.add(cardinfo);
            }
        }


        //批量插入
        boolean a = idCardService.insertBatch(list);
        System.out.println(a);
        //批量更新
        if (list2.size()>0){
            boolean b = idCardService.updateBatch(list2);
            System.out.println(b);
        }
        return CommonReturnType.createCommonReturnType(null);
    }



    //补全信息
    @RequestMapping(value = "getAll",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType getAll(){
        List<TbIdcard> list = idCardService.selectAll();
        for (int i=0;i<list.size();i++){

        }

        return CommonReturnType.createCommonReturnType(null);
    }




    public static void main(String[] args) {
       String strTime =  MyTools.getTime().substring(0,10);
        System.out.println(strTime);
    }




}
