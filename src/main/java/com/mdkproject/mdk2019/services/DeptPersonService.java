package com.mdkproject.mdk2019.services;

import com.mdkproject.mdk2019.entity.DeptPerson;
import com.mdkproject.mdk2019.error.BusinessException;
import com.mdkproject.mdk2019.services.model.DeptPersonModel;

import java.util.List;

/**
 * @auther: lizhen
 * @date: 2019-04-03 11:03
 * 功能描述: 单位人员录入
 */
public interface DeptPersonService {
    //新增
    DeptPersonModel add(DeptPersonModel deptPersonModel) throws BusinessException;

    //详情
    DeptPersonModel get(Integer deptId);

    //列表
    List<DeptPersonModel> listDeptPerson();

    //批量添加
    List<DeptPerson> insertList(List<DeptPersonModel> deptPersonModel) throws BusinessException;




}
