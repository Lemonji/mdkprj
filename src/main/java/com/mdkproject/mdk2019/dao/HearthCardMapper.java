package com.mdkproject.mdk2019.dao;

import com.mdkproject.mdk2019.entity.HearthCard;

import java.util.List;

public interface HearthCardMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_hearth_card
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    int deleteByPrimaryKey(Integer healthId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_hearth_card
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    int insert(HearthCard record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_hearth_card
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    int insertSelective(HearthCard record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_hearth_card
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    HearthCard selectByPrimaryKey(Integer healthId);

    //根据身份证号获取健康证信息
    HearthCard getHealthCard(String idCard);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_hearth_card
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    int updateByPrimaryKeySelective(HearthCard record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_hearth_card
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    int updateByPrimaryKey(HearthCard record);


    //查询当日发证数量/制证数量
    int daycardnum(String nowdate);

    List<HearthCard> weektjnum();
}