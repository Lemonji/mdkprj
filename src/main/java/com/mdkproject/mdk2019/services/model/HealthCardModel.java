package com.mdkproject.mdk2019.services.model;

import lombok.Data;

/**
 * @Auther: Liberal-World
 * @Date: 2019-04-02 17:00
 * @Description:健康证MODEL
 * @Version 1.0
 */
@Data
public class HealthCardModel {
    private Integer healthId;
    private String name;
    private Integer age;
    private String gender;
    private String medical;
    private String idCard;
    private String healthNum;
    private String healthTime;
    private String qrCode;
    private String hospitalId;
    private String createTime;
    private String updateTime;
    private String createby;


    private String address;
    private String gz;




}
