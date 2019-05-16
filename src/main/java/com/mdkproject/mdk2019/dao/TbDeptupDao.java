package com.mdkproject.mdk2019.dao;

import com.mdkproject.mdk2019.entity.TbDeptup;

import java.util.List;

public interface TbDeptupDao {
    int deleteByPrimaryKey(Integer deptId);

    int insert(TbDeptup record);

    int insertSelective(TbDeptup record);

    TbDeptup selectByPrimaryKey(Integer deptId);

    int updateByPrimaryKeySelective(TbDeptup record);

    int updateByPrimaryKey(TbDeptup record);

    int updateStatus(int deptid,int status);

    List<TbDeptup> getorderres(int status,int page);
}