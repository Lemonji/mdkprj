package com.mdkproject.mdk2019.dao;

import com.mdkproject.mdk2019.entity.Hospital;

import java.util.List;

public interface HospitalMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_hospital
     *
     * @mbg.generated Tue Apr 02 16:50:27 CST 2019
     */
    int deleteByPrimaryKey(Integer hospitalId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_hospital
     *
     * @mbg.generated Tue Apr 02 16:50:27 CST 2019
     */
    int insert(Hospital record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_hospital
     *
     * @mbg.generated Tue Apr 02 16:50:27 CST 2019
     */
    int insertSelective(Hospital record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_hospital
     *
     * @mbg.generated Tue Apr 02 16:50:27 CST 2019
     */
    Hospital selectByPrimaryKey(Integer hospitalId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_hospital
     *
     * @mbg.generated Tue Apr 02 16:50:27 CST 2019
     */
    int updateByPrimaryKeySelective(Hospital record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_hospital
     *
     * @mbg.generated Tue Apr 02 16:50:27 CST 2019
     */
    int updateByPrimaryKey(Hospital record);

    List<Hospital> findAll();

    List<String> findbyqu(String quname);
}