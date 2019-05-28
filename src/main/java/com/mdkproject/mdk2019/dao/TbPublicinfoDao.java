package com.mdkproject.mdk2019.dao;

import com.mdkproject.mdk2019.entity.TbPublicinfo;

import java.util.List;

public interface TbPublicinfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TbPublicinfo record);

    int insertSelective(TbPublicinfo record);

    TbPublicinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbPublicinfo record);

    int updateByPrimaryKey(TbPublicinfo record);

    List<TbPublicinfo> findthreeinfo();
}