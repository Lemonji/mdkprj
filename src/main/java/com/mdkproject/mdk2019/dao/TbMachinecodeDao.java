package com.mdkproject.mdk2019.dao;

import com.mdkproject.mdk2019.entity.TbMachinecode;

public interface TbMachinecodeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TbMachinecode record);

    //增加机器码，一次一百个,系统随机生成
    int insertSelective(TbMachinecode record);

    TbMachinecode selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(TbMachinecode record);

    int updateByPrimaryKey(TbMachinecode record);

    //当机器被激活时，返回机器的状态,并且要记录激活时间，激活单位信息
    TbMachinecode activeMachine(String record);
    int updateTime(TbMachinecode machinecode);
    int findFirstId();
}