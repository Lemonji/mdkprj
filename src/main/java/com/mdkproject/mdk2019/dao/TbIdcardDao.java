package com.mdkproject.mdk2019.dao;

import com.mdkproject.mdk2019.entity.TbIdcard;

import java.util.List;

public interface TbIdcardDao {
    int deleteByPrimaryKey(Integer healthNum);

    int insert(TbIdcard record);

    int insertSelective(TbIdcard record);

    TbIdcard selectByPrimaryKey(Integer healthNum);

    int updateByPrimaryKeySelective(TbIdcard record);

    int updateByPrimaryKey(TbIdcard record);

    TbIdcard selectByIdnum(String idnum);

    //批量插入
    List<TbIdcard> insertBatch(List<TbIdcard> cardinfo);

    //批量更新
    List<TbIdcard> Updatebatch(List<TbIdcard> cardinfo);

}