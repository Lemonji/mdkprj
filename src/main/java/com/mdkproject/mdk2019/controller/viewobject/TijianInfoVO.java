package com.mdkproject.mdk2019.controller.viewobject;

import lombok.Data;

/**
 * @Auther: Liberal-World
 * @Date: 2019-04-11 11:25
 * @Description:
 * @Version 1.0
 */
@Data
public class TijianInfoVO {
    private Integer tjId;
    private String number;          //编号
    private String telphone;        //手机号
    private String name;            //姓名
    private String sex;             //健康证编号
    private Integer age;            //年龄
    private String idcardNum;       //身份证号
    private String hearthcardNum;   //健康证编号
    private String company;         //单位
    private String adress;          //通讯地址
    private String idcardPhtoto;    //照片
    private String person;          //办证人员
    private String deptNum;         //办证单位
    private String startdate;       //办证日期
    private String enddate;         //有效期至
    private String createTime;      //创建时间
    private String updateTime;      //更新时间

}
