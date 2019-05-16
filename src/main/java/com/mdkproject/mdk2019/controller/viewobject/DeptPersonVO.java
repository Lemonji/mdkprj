package com.mdkproject.mdk2019.controller.viewobject;

/**
 * @Auther: Liberal-World
 * @Date: 2019-04-03 11:02
 * @Description:
 * @Version 1.0
 */
public class DeptPersonVO {
    private Integer deptId;
    private String deptName;        //单位名称
    private String deptCode;        //单位统一征信代码
    private String deptPname;       //单位人员姓名
    private String deptGender;      //性别
    private String deptIdcard;      //身份证号
    private String deptPhone;       //手机号

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
}
