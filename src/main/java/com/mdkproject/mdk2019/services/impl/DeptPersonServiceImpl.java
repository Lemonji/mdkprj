package com.mdkproject.mdk2019.services.impl;

import com.mdkproject.mdk2019.dao.DeptPersonMapper;
import com.mdkproject.mdk2019.entity.DeptPerson;
import com.mdkproject.mdk2019.error.BusinessException;
import com.mdkproject.mdk2019.error.EmBusinessError;
import com.mdkproject.mdk2019.services.DeptPersonService;
import com.mdkproject.mdk2019.services.model.DeptPersonModel;
import com.mdkproject.mdk2019.validator.ValidationResult;
import com.mdkproject.mdk2019.validator.ValidatorImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: Liberal-World
 * @Date: 2019-04-03 11:06
 * @Description:单位人员录入
 * @Version 1.0
 */
@Service
public class DeptPersonServiceImpl implements DeptPersonService {
    @Autowired
    private DeptPersonMapper deptPersonMapper;
    @Autowired
    private ValidatorImpl validator;


    //新增人员
    @Override
    public DeptPersonModel add(DeptPersonModel deptPersonModel) throws BusinessException {
        //入参校验
        ValidationResult result = validator.validate(deptPersonModel);
        if (result.isHasErrors()){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,result.getErrMsg());
        }

        //model --> entity
        DeptPerson deptPerson = this.convertDeptPersonFromDeptPersonModel(deptPersonModel);

        deptPersonMapper.insertSelective(deptPerson);
        deptPersonModel.setDeptId(deptPerson.getDeptId());
        return this.get(deptPersonModel.getDeptId());
    }

    //详情
    @Override
    public DeptPersonModel get(Integer deptId) {
        DeptPerson deptPerson = deptPersonMapper.selectByPrimaryKey(deptId);
        if (deptPerson==null){
            return null;
        }
        DeptPersonModel deptPersonModel = this.convertDeptPersonModelFromDeptPerson(deptPerson);
        return deptPersonModel;
    }

    //列表
    @Override
    public List<DeptPersonModel> listDeptPerson() {
        List<DeptPerson> deptPersonList = deptPersonMapper.listDeptPerson();
        //使用stream api 将list内的model转化为entity
        List<DeptPersonModel> deptPersonModelList = deptPersonList.stream().map(deptPerson -> {
            DeptPersonModel deptPersonModel = this.convertDeptPersonModelFromDeptPerson(deptPerson);
            return deptPersonModel;
        }).collect(Collectors.toList());
        return deptPersonModelList;
    }


    //批量添加
    @Override
    public List<DeptPerson> insertList(List<DeptPersonModel> deptPersonModel) throws BusinessException {
        ValidationResult result = validator.validate(deptPersonModel);
        if (result.isHasErrors()){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,result.getErrMsg());
        }
        //model--->entity
        List<DeptPerson> deptPersonlList = deptPersonModel.stream().map(deptPersonModel1 -> {
            DeptPerson deptPerson = this.convertDeptPersonFromDeptPersonModel(deptPersonModel1);
            return deptPerson;
        }).collect(Collectors.toList());

        //入库
        deptPersonMapper.insertBatch(deptPersonlList);
        return deptPersonlList;
    }


    //model --> entity领域模型
    private DeptPerson convertDeptPersonFromDeptPersonModel(DeptPersonModel deptPersonModel){
        if (deptPersonModel==null){
            return null;
        }
        DeptPerson deptPerson = new DeptPerson();
        BeanUtils.copyProperties(deptPersonModel,deptPerson);
        return deptPerson;
    }
    //entity --> model
    private DeptPersonModel convertDeptPersonModelFromDeptPerson(DeptPerson deptPerson){
        if (deptPerson==null){
            return null;
        }
        DeptPersonModel deptPersonModel = new DeptPersonModel();
        BeanUtils.copyProperties(deptPerson,deptPersonModel);
        return deptPersonModel;
    }
}
