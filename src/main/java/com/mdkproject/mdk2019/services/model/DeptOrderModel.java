package com.mdkproject.mdk2019.services.model;

import javax.validation.constraints.NotBlank;

/**
 * @Auther: Liberal-World
 * @Date: 2019-04-03 09:25
 * @Description:单位预约
 * @Version 1.0
 */
public class DeptOrderModel {
    private Integer deptId;

    @NotBlank(message = "不能不填")
    private String deptOrganization;        //体检机构
    @NotBlank(message = "不能不填")
    private String deptName;                //单位名称
    @NotBlank(message = "不能不填")
    private String deptCode;                //单位统一征信代码
    @NotBlank(message = "不能不填")
    private String deptTel;                 //预约人预留电话

    private String createTime;              //创建时间
    private String updateTime;              //更新时间


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
