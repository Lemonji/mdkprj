package com.mdkproject.mdk2019.dao;

import com.mdkproject.mdk2019.entity.UserRole;

public interface UserRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated Wed Apr 10 11:07:15 CST 2019
     */
    int deleteByPrimaryKey(Integer roleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated Wed Apr 10 11:07:15 CST 2019
     */
    int insert(UserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated Wed Apr 10 11:07:15 CST 2019
     */
    int insertSelective(UserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated Wed Apr 10 11:07:15 CST 2019
     */
    UserRole selectByPrimaryKey(Integer roleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated Wed Apr 10 11:07:15 CST 2019
     */
    int updateByPrimaryKeySelective(UserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated Wed Apr 10 11:07:15 CST 2019
     */
    int updateByPrimaryKey(UserRole record);
}