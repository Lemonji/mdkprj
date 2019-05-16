package com.mdkproject.mdk2019.services;

import com.mdkproject.mdk2019.entity.TbDeptup;

import java.util.List;

public interface DeptupService {
    //依据审核状态查询审核结果
    List<TbDeptup> getorderres(int status,int pagenum);

    //修改审核结果
    int updatestatus(int deptid,int status);
}
