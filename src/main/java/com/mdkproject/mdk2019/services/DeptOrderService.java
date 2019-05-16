package com.mdkproject.mdk2019.services;

import com.mdkproject.mdk2019.entity.DeptOrder;
import com.mdkproject.mdk2019.error.BusinessException;
import com.mdkproject.mdk2019.services.model.DeptOrderModel;

import java.util.List;

/**
 * @auther: lizhen
 * @date: 2019-04-03 9:24
 * 功能描述: 单位预约
 */
public interface DeptOrderService {

    //新增预约
    DeptOrderModel deptorder(DeptOrderModel deptOrderModel) throws BusinessException;

    //预约详情
    DeptOrderModel getDeptOrder(Integer deptId);

    int dayordernum();

    List<DeptOrder> weektjnum();
}
