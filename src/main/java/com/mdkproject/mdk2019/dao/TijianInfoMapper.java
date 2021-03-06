package com.mdkproject.mdk2019.dao;

import com.mdkproject.mdk2019.entity.TijianInfo;

import java.util.List;
import java.util.Map;

public interface TijianInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_tijianinfo
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    int deleteByPrimaryKey(Integer tjId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_tijianinfo
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    int insert(TijianInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_tijianinfo
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    int insertSelective(TijianInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_tijianinfo
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    TijianInfo selectByPrimaryKey(Integer tjId);

    //根据身份证号查询
    TijianInfo selectByIdCard(String idcardNum);
    //列表降序
    List<TijianInfo> listTjInfo();
    //时间段检索
    List<TijianInfo> selectByStartToEnd(String startTime,String endTime);


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_tijianinfo
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    int updateByPrimaryKeySelective(TijianInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_tijianinfo
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    int updateByPrimaryKey(TijianInfo record);

    //
    List findbycondition(Map condition);

    int updateStatus(String number,int status);

    int daytjnum(String createtime);

    int monthtjnum(String monthdate);

    int alltjnum();

    List<TijianInfo> weektjnum();

    //健康检查表查询
    List<TijianInfo> findtjporj(Map conditions);

    TijianInfo getlastnum();

    List daytjlist(String daytime);

    String gettjstatus(String idnum);

    int getzerostatus();
    int getonestatus();
    int getotwostatus();

    List<TijianInfo> getzerolist();
    List<TijianInfo> getonelist();
    List<TijianInfo> gettwolist();

    int updatehospital(String str,String hospitalname);

    int deletetjinfo(String str);
}