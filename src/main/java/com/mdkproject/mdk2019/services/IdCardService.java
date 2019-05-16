package com.mdkproject.mdk2019.services;

import com.mdkproject.mdk2019.entity.TbIdcard;

import java.util.List;

public interface IdCardService {
    int insert(TbIdcard tbIdcard);
    int insertSelective(TbIdcard record);
    TbIdcard selectByIdnum(String idnum);
    int deleteByPrimaryKey(Integer healthNum);

    //批量插入
    boolean insertBatch(List<TbIdcard> list);

    //批量更新
    boolean updateBatch(List<TbIdcard> list2);


    List<TbIdcard> selectAll();
}
