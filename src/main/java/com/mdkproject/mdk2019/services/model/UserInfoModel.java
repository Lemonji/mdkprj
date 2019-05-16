package com.mdkproject.mdk2019.services.model;

import lombok.Data;

/**
 * @Auther: Liberal-World
 * @Date: 2019-04-10 09:46
 * @Description: 用户
 * @Version 1.0
 */

@Data
public class UserInfoModel {

    private Integer userid;
    private String account;         //账号
    private String password;        //盐加密密码
    private String viKey;           //加密狗
    private String name;            //姓名
    private String sex;             //性别
    private String telphone;        //手机号
    private String status;          //状态
    private String roleId;          //角色ID
    private Integer deptId;         //部门ID
    private String createTime;      //创建时间
    private String updateTime;      //更新时间
    private String createby;        //创建人

    private String token;





}
