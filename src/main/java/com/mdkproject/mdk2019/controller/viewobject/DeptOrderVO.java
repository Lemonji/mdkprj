package com.mdkproject.mdk2019.controller.viewobject;

/**
 * @Auther: Liberal-World
 * @Date: 2019-04-03 09:53
 * @Description:单位预约
 * @Version 1.0
 */
public class DeptOrderVO {


    private Integer deptId;
    private String deptOrganization;
    private String deptName;
    private String deptCode;
    private String deptTel;
    private String createTime;
    private String updateTime;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptOrganization() {
        return deptOrganization;
    }

    public void setDeptOrganization(String deptOrganization) {
        this.deptOrganization = deptOrganization;
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

    public String getDeptTel() {
        return deptTel;
    }

    public void setDeptTel(String deptTel) {
        this.deptTel = deptTel;
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
