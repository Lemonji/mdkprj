package com.mdkproject.mdk2019.controller.viewobject;

import lombok.Data;

/**
 * @Auther: Liberal-World
 * @Date: 2019-04-02 17:16
 * @Description:
 * @Version 1.0
 */
@Data
public class HearthCardVO {

    private Integer healthId;           //id
    private String name;                //姓名
    private Integer age;                //年龄
    private String gender;              //性别
    private String medical;             //是否合格
    private String idCard;              //身份证号
    private String healthNum;           //健康证编号
    private String healthTime;          //健康证有效期
    private String qrCode;              //二维码，条形码

    private String address;             //体检机构地址
    private String gz;                  //公章


}
