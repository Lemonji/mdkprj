package com.mdkproject.mdk2019.services.model;

import javax.validation.constraints.NotBlank;

/**
 * @Auther: Liberal-World
 * @Date: 2019-04-03 10:55
 * @Description:单位人员录入
 * @Version 1.0
 */
public class DeptPersonModel {
    private Integer deptId;

    @NotBlank(message = "不能为空")
    private String deptName;        //单位名称
    @NotBlank(message = "不能为空")
    private String deptCode;        //单位统一征信代码
    @NotBlank(message = "不能为空")
    private String deptPname;       //单位人员姓名
    @NotBlank(message = "不能为空")
    private String deptGender;      //性别
    @NotBlank(message = "不能为空")
    private String deptIdcard;      //身份证号
    @NotBlank(message = "不能为空")
    private String deptPhone;       //手机号

    private String createTime;
    private String updateTime;



    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptPname() {
        return deptPname;
    }

    public void setDeptPname(String deptPname) {
        this.deptPname = deptPname;
    }

    public String getDeptGender() {
        return deptGender;
    }

    public void setDeptGender(String deptGender) {
        this.deptGender = deptGender;
    }

    public String getDeptIdcard() {
        return deptIdcard;
    }

    public void setDeptIdcard(String deptIdcard) {
        this.deptIdcard = deptIdcard;
    }

    public String getDeptPhone() {
        return deptPhone;
    }

    public void setDeptPhone(String deptPhone) {
        this.deptPhone = deptPhone;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
