package com.mdkproject.mdk2019.services.model;

import lombok.Data;

/**
 * @Auther: Liberal-World
 * @Date: 2019-04-15 13:52
 * @Description: 体检项目Model
 * @Version 1.0
 */
@Data
public class TijianProjectModel {
    private Integer id;

    //病史
    private String ganyan;
    private String liji;
    private String shanghan;
    private String feijiehe;
    private String pifubing;

    //体征
    private String xin;
    private String gan;
    private String pi;
    private String fei;
    private String pifu;

    //X线胸透
    private String xPicture;

    //实验室检验
    private String alt;
    private String antiHav;
    private String antiHev;

    //结论
    private String jielun;          //体检结论
    private String yijian;          //意见
    private String gz;              //公章
    private String status;          //检查结论：是否合格
    private String noProject;       //不合格项目
    private String hearthCardid;    //健康证ID
    private String startTime;       //发证日期
    private String endTime;         //有效日期


    private String personIdcard;    //体检人员身份证ID
    private String doctor;          //医生签名
    private String qt;              //其他
    private String createTime;      //创建时间
    private String updateTime;      //更新时间


    //体检表
    private String orderTime;       //预约时间
    private String hearthCardNum;   //健康证编号
    private String name;
    private String sex;
    private Integer age;
    private String dept;
    private String idcardPhoto;



}
