package com.mdkproject.mdk2019.services;

import com.mdkproject.mdk2019.entity.DeptOrderExcel;
import com.mdkproject.mdk2019.error.BusinessException;

import java.util.List;

/**
 * @Auther: Liberal-World
 * @Date: 2019-04-19 10:41
 * @Description: 预约单位excel
 * @Version 1.0
 */
public interface DeptOrderExcelService {

    //excel插入
    boolean insertDeptOrderExcel(DeptOrderExcel deptOrderExcel) throws BusinessException;

    //列表
    List<DeptOrderExcel> listDeptOrderExcel();

    //刷身份证补全信息

    boolean updateDeptOrderInfo(String idCard);


}
