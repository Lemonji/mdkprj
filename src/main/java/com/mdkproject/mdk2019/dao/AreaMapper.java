package com.mdkproject.mdk2019.dao;

import com.mdkproject.mdk2019.entity.Area;

import java.util.List;

public interface AreaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_area
     *
     * @mbg.generated Tue Apr 02 16:50:27 CST 2019
     */
    int deleteByPrimaryKey(Integer areaId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_area
     *
     * @mbg.generated Tue Apr 02 16:50:27 CST 2019
     */
    int insert(Area record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_area
     *
     * @mbg.generated Tue Apr 02 16:50:27 CST 2019
     */
    int insertSelective(Area record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_area
     *
     * @mbg.generated Tue Apr 02 16:50:27 CST 2019
     */
    Area selectByPrimaryKey(Integer areaId);

    List<Area> listArea();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_area
     *
     * @mbg.generated Tue Apr 02 16:50:27 CST 2019
     */
    int updateByPrimaryKeySelective(Area record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_area
     *
     * @mbg.generated Tue Apr 02 16:50:27 CST 2019
     */
    int updateByPrimaryKey(Area record);
}