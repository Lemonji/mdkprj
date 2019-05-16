package com.mdkproject.mdk2019.services.impl;

import com.mdkproject.mdk2019.dao.DeptOrderExcelMapper;
import com.mdkproject.mdk2019.entity.DeptOrderExcel;
import com.mdkproject.mdk2019.error.BusinessException;
import com.mdkproject.mdk2019.error.EmBusinessError;
import com.mdkproject.mdk2019.services.DeptOrderExcelService;
import com.mdkproject.mdk2019.validator.ValidationResult;
import com.mdkproject.mdk2019.validator.ValidatorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Liberal-World
 * @Date: 2019-04-19 10:41
 * @Description:
 * @Version 1.0
 */

@Service
public class DeptOrderExcelServiceImpl implements DeptOrderExcelService {
    @Autowired
    private DeptOrderExcelMapper deptOrderExcelMapper;
    @Autowired
    private ValidatorImpl validator;

    @Override
    public boolean insertDeptOrderExcel(DeptOrderExcel deptOrderExcel) throws BusinessException {
        ValidationResult result = validator.validate(deptOrderExcel);
        if (result.isHasErrors()){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,result.getErrMsg());
        }
        //入库
        try {
            deptOrderExcelMapper.insertSelective(deptOrderExcel);
            return true ;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    //列表
    @Override
    public List<DeptOrderExcel> listDeptOrderExcel() {


        return null;
    }


    //刷身份证补全信息
    @Override
    public boolean updateDeptOrderInfo(String idCard) {
        if(idCard==null){
            return false;
        }




        return false;
    }


}
