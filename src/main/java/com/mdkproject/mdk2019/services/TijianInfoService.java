package com.mdkproject.mdk2019.services;

import com.mdkproject.mdk2019.entity.TijianInfo;
import com.mdkproject.mdk2019.error.BusinessException;
import com.mdkproject.mdk2019.services.model.TijianModel;

import java.util.List;
import java.util.Map;

/**
 * @auther: lizhen
 * @date: 2019-04-11 10:15
 * 功能描述: 体检信息基础录入
 */
public interface TijianInfoService {



    //添加
    TijianModel save(TijianModel tijianModel) throws BusinessException;

    //详情
    TijianModel getTjById(Integer tjId);

    //列表
    List<TijianModel> listTijian();

    //起止时间检索
    List<TijianModel> selectByStartToEnd(String startTime,String endTime);

    List findbycondition(Map condition);

    int updateStatus(String number,int status);

    int daytjnum();

    int monthtjnum();

    int alltjnum();

    List<TijianInfo> weektjnum();

    List<TijianInfo> findtjporj(Map conditions);

    TijianInfo getlastnum();

    List<TijianModel> daytjlist(String daytime);

    String gettjstatus(String idnum);

    int getzerostatus();
    int getonestatus();
    int getotwostatus();

    List<TijianInfo> getzerolist();
    List<TijianInfo> getonelist();
    List<TijianInfo> gettwolist();
}
