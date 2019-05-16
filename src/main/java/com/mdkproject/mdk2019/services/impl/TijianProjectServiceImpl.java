package com.mdkproject.mdk2019.services.impl;

import com.mdkproject.mdk2019.dao.*;
import com.mdkproject.mdk2019.entity.*;
import com.mdkproject.mdk2019.error.BusinessException;
import com.mdkproject.mdk2019.error.EmBusinessError;
import com.mdkproject.mdk2019.services.TijianProjectService;
import com.mdkproject.mdk2019.services.model.TijianProjectModel;
import com.mdkproject.mdk2019.utils.MyTools;
import com.mdkproject.mdk2019.validator.ValidationResult;
import com.mdkproject.mdk2019.validator.ValidatorImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Liberal-World
 * @Date: 2019-04-15 13:40
 * @Description:体检项目
 * @Version 1.0
 */
@Service
public class TijianProjectServiceImpl implements TijianProjectService {
    @Autowired
    private SicknessHistoryMapper sicknessHistoryMapper;
    @Autowired
    private SignMapper signMapper;
    @Autowired
    private XpictureMapper xpictureMapper;
    @Autowired
    private LabMapper labMapper;
    @Autowired
    private JieLunMapper jieLunMapper;

    @Autowired
    private ValidatorImpl validator;

    @Autowired
    private DeptPersonMapper deptPersonMapper;          //单位
    @Autowired
    private TijianInfoMapper tijianInfoMapper;          //体检信息




    //创建体检项目
    @Override
    @Transactional
    public TijianProjectModel add(TijianProjectModel tijianProjectModel) throws BusinessException {
        //校验
        ValidationResult result = validator.validate(tijianProjectModel);
        if (result.isHasErrors()){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,result.getErrMsg());
        }
        tijianProjectModel.setCreateTime(MyTools.getTime());    //创建时间
        tijianProjectModel.setUpdateTime(MyTools.getTime());    //更新时间
        //model ---> entity
        //病史
        SicknessHistory sicknessHistory = this.convertSicknessHistoryFromModle(tijianProjectModel);
        sicknessHistoryMapper.insertSelective(sicknessHistory);

        //体征
        Sign sign = this.convertSignFromModel(tijianProjectModel);
        signMapper.insertSelective(sign);

        //X线
        Xpicture xpictures = this.convertXpictureFromModel(tijianProjectModel);
        xpictureMapper.insertSelective(xpictures);

        //检验
        Lab lab = this.convertLabFromModel(tijianProjectModel);
        labMapper.insertSelective(lab);

        //结论
        JieLun jieLun = this.convertJieLunFromModel(tijianProjectModel);
        jieLunMapper.insertSelective(jieLun);
        return null;
    }



    //体检表
    @Override
    public Map<String, Object> findByIdcard(String personIdcard) throws BusinessException {

        Map<String,Object> map = new HashMap<>();
        //单位信息
        DeptPerson deptinfo = deptPersonMapper.findByIdcard(personIdcard);

        //体检信息
        TijianInfo tijianInfo = tijianInfoMapper.selectByIdCard(personIdcard);


        //体检项目
        SicknessHistory sicknessHistory = sicknessHistoryMapper.findByIdcard(personIdcard);
        Sign sign = signMapper.findByIdcard(personIdcard);
        Xpicture xpicture = xpictureMapper.findByIdcard(personIdcard);
        Lab lab = labMapper.findByIdcard(personIdcard);
        JieLun jieLun = jieLunMapper.findByIdcard(personIdcard);


        try {
            map.put("deptName",deptinfo.getDeptName());
            map.put("tijianInfo",tijianInfo);
            map.put("sicknessHistory",sicknessHistory);
            map.put("sign",sign);
            map.put("xpicture",xpicture);
            map.put("lab",lab);
            map.put("jieLun",jieLun);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("somewhereisnull");
        }
        return map;
    }




    //模型转化
    //病史
    private SicknessHistory convertSicknessHistoryFromModle(TijianProjectModel tijianProjectModel){
        SicknessHistory sicknessHistory = new SicknessHistory();
        BeanUtils.copyProperties(tijianProjectModel,sicknessHistory);
        return sicknessHistory;
    }
    //体征
    private Sign convertSignFromModel(TijianProjectModel TijianProjectModel){
        Sign sign = new Sign();
        BeanUtils.copyProperties(TijianProjectModel,sign);
        return sign;
    }
    //x线
    private Xpicture convertXpictureFromModel(TijianProjectModel tijianProjectModel){
        Xpicture xpicture = new Xpicture();
        BeanUtils.copyProperties(tijianProjectModel,xpicture);
        return xpicture;
    }
    //检验
    private Lab convertLabFromModel(TijianProjectModel tijianProjectModel){
        Lab lab = new Lab();
        BeanUtils.copyProperties(tijianProjectModel,lab);
        return lab;
    }
    //结论
    private JieLun convertJieLunFromModel(TijianProjectModel tijianProjectModel){
        JieLun jieLun = new JieLun();
        BeanUtils.copyProperties(tijianProjectModel,jieLun);
        return jieLun;
    }


    //entity ---> model
    private TijianProjectModel convertModelFromEntity(TijianInfo tijianInfo,DeptPerson dept){
        TijianProjectModel model = new TijianProjectModel();
        model.setDept(dept.getDeptName());                          //单位
        model.setCreateTime(tijianInfo.getCreateTime());            //体检时间
        model.setName(tijianInfo.getName());                        //姓名
        model.setSex(tijianInfo.getSex());                          //性别
        model.setAge(tijianInfo.getAge());                          //年龄
        model.setIdcardPhoto(tijianInfo.getIdcardPhtoto());         //照片
        model.setHearthCardid(tijianInfo.getHearthcardNum());       //健康证编号
        return model;
    }

    //
    private TijianProjectModel convertModelFromEntity(Object object){
        TijianProjectModel tijianProjectModel = new TijianProjectModel();
        BeanUtils.copyProperties(object,tijianProjectModel);
        return tijianProjectModel;
    }



}
