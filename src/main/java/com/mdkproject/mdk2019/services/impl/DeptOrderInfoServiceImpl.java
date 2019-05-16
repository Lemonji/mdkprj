package com.mdkproject.mdk2019.services.impl;

import com.mdkproject.mdk2019.dao.DeptOrderInfoMapper;
import com.mdkproject.mdk2019.entity.DeptOrderInfo;
import com.mdkproject.mdk2019.services.DeptOrderInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: Liberal-World
 * @Date: 2019-04-27 18:06
 * @Description: 依据身份证号补全信息service
 * @Version 1.0
 */

@Service
public class DeptOrderInfoServiceImpl implements DeptOrderInfoService {


    @Autowired
    private DeptOrderInfoMapper deptOrderInfoMapper;
    private static final Logger logger = LoggerFactory.getLogger(DeptOrderInfoServiceImpl.class);

    @Override
    public boolean updateByIdCard(String idCard,String photo) {
        try {
            DeptOrderInfo deptOrderInfo = deptOrderInfoMapper.selectByIdCard(idCard);   //获取
            //判断，新增
            if(deptOrderInfo==null){
                logger.info("导入信息没有此人！");
                return false;
            }
            deptOrderInfo.setpPhoto(photo);
            deptOrderInfoMapper.updateByPrimaryKey(deptOrderInfo);          //更新
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }




}
