package com.mdkproject.mdk2019.services.impl;

import com.mdkproject.mdk2019.dao.DeptOrderMapper;
import com.mdkproject.mdk2019.entity.DeptOrder;
import com.mdkproject.mdk2019.error.BusinessException;
import com.mdkproject.mdk2019.error.EmBusinessError;
import com.mdkproject.mdk2019.services.DeptOrderService;
import com.mdkproject.mdk2019.services.model.DeptOrderModel;
import com.mdkproject.mdk2019.utils.SimpledateUtil;
import com.mdkproject.mdk2019.validator.ValidationResult;
import com.mdkproject.mdk2019.validator.ValidatorImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Liberal-World
 * @Date: 2019-04-03 09:24
 * @Description:单位预约
 * @Version 1.0
 */
@Service
public class DeptOrderServiceImpl implements DeptOrderService {

    @Autowired
    private DeptOrderMapper deptOrderMapper;
    @Autowired
    private ValidatorImpl validator;

    //新增预约
    @Override
    public DeptOrderModel deptorder(DeptOrderModel deptOrderModel) throws BusinessException {
        //校验入参
        ValidationResult result = validator.validate(deptOrderModel);
        if (result.isHasErrors()){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,result.getErrMsg());
        }

        //model ---> entity
        DeptOrder deptOrder = this.convertDeptOrderFromDeptOrderModel(deptOrderModel);

        //入库
        deptOrderMapper.insertSelective(deptOrder);
        deptOrderModel.setDeptId(deptOrder.getDeptId());

        //返回对象显示
        return this.getDeptOrder(deptOrderModel.getDeptId());

    }

    //预约详情
    @Override
    public DeptOrderModel getDeptOrder(Integer deptId) {
        DeptOrder deptOrder = deptOrderMapper.selectByPrimaryKey(deptId);
        if (deptOrder==null){
            return null;
        }

        //entity ---> model
        DeptOrderModel deptOrderModel = this.convertDeptOrderModelFromDeptOrder(deptOrder);
        return deptOrderModel;
    }




    //model ---> entity领域模型
    private DeptOrder convertDeptOrderFromDeptOrderModel(DeptOrderModel deptOrderModel){
        if (deptOrderModel==null){
            return null;
        }
        DeptOrder deptOrder = new DeptOrder();
        BeanUtils.copyProperties(deptOrderModel,deptOrder);
        return deptOrder;
    }

    //entity ---> model领域模型
    private DeptOrderModel convertDeptOrderModelFromDeptOrder(DeptOrder deptOrder){
        DeptOrderModel deptOrderModel = new DeptOrderModel();
        BeanUtils.copyProperties(deptOrder,deptOrderModel);
        return deptOrderModel;
    }

    @Override
    public int dayordernum(){
        String nowdate= SimpledateUtil.getSimpledate();
        return deptOrderMapper.dayordernum(nowdate);
    }

    @Override
    public List<DeptOrder> weektjnum() {
        return deptOrderMapper.weektjnum();
    }

}
