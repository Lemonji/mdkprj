package com.mdkproject.mdk2019.services.impl;

import com.mdkproject.mdk2019.dao.HearthCardMapper;
import com.mdkproject.mdk2019.dao.HospitalMapper;
import com.mdkproject.mdk2019.entity.HearthCard;
import com.mdkproject.mdk2019.entity.Hospital;
import com.mdkproject.mdk2019.services.HearthCardService;
import com.mdkproject.mdk2019.services.model.HealthCardModel;
import com.mdkproject.mdk2019.utils.ImgOrBase64;
import com.mdkproject.mdk2019.utils.SimpledateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Liberal-World
 * @Date: 2019-04-02 16:53
 * @Description:
 * @Version 1.0
 */
@Service
public class HearthCardServiceImpl implements HearthCardService {
    @Autowired
    private HearthCardMapper hearthCardMapper;
    @Autowired
    private HospitalMapper hospitalMapper;

    //身份证号查询健康证
    @Override
    public HealthCardModel getHealthCard(String idCard) {
        HearthCard healthCard = hearthCardMapper.getHealthCard(idCard);
        if (healthCard==null){
            return null;
        }
        //图片-->base64
        String qrStr = ImgOrBase64.imageToBase64Str(healthCard.getQrCode());    //二维码
        healthCard.setQrCode(qrStr);
        Hospital hospital = hospitalMapper.selectByPrimaryKey(Integer.valueOf(healthCard.getHospitalId()));
        String gz = ImgOrBase64.imageToBase64Str(hospital.getHospitalGz());     //公章
        hospital.setHospitalGz(gz);
        //entity ---> model
        HealthCardModel healthCardModel = this.convertModelFromEntity(healthCard, hospital);
        //获取到模型
        return healthCardModel;

    }

    @Override
    public int daycardnum() {
        String nowdate= SimpledateUtil.getSimpledate();
        return hearthCardMapper.daycardnum(nowdate);
    }

    @Override
    public List<HearthCard> weektjnum() {
        return hearthCardMapper.weektjnum();
    }

    public String getlastnum(){
        return hearthCardMapper.getlastnum();
    }

    //领域模型(对象-->模型)
    private HealthCardModel convertModelFromEntity(HearthCard healthCard, Hospital hospital){
        HealthCardModel healthCardModel = new HealthCardModel();
        BeanUtils.copyProperties(healthCard,healthCardModel);
        healthCardModel.setAddress(hospital.getHospitalProvince()+hospital.getHospitalCity()+hospital.getHospitalDistrict()+hospital.getHospitalAddress());   //地址
        healthCardModel.setGz(hospital.getHospitalGz());                     //公章
        return healthCardModel;
    }
}
