package com.mdkproject.mdk2019.entity;

import lombok.Data;

/**
 * tb_idcard
 * @author 
 */
@Data
public class TbIdcard  {
    /**
     * 健康证编号，自动增长
     */
    private Integer healthNum;

    /**
     * 姓名
     */
    private String name;

    /**
     * 身份证号
     */
    private String idcardNum;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private String sex;

    /**
     * 民族
     */
    private String nation;

    /**
     * 头像
     */
    private String photo;

    /**
     * 身份证起效日期
     */
    private String starttime;

    /**
     * 身份证失效日期
     */
    private String endtime;

    /**
     * 创建时间
     */
    private String createtime;

    /**
     * 住址
     */
    private String address;

    /**
     * 公安局（签证机关）
     */
    private String psb;


}