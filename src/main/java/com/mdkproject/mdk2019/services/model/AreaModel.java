package com.mdkproject.mdk2019.services.model;

import javax.validation.constraints.NotBlank;

/**
 * @Auther: Liberal-World
 * @Date: 2019-03-28 09:16
 * @Description:
 * @Version 1.0
 */
public class AreaModel {
    private Integer areaId;

    @NotBlank(message = "区域名不能为空")
    private String areaName;

    @NotBlank(message = "区域编号不能为空")
    private String areaNum;

    @NotBlank(message = "创建时间不能为空")
    private String createTime;

    @NotBlank(message = "更新时间不能为空")
    private String updateTime;

    @NotBlank(message = "创建人不能为空")
    private String createby;







    //get set
    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaNum() {
        return areaNum;
    }

    public void setAreaNum(String areaNum) {
        this.areaNum = areaNum;
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

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby;
    }
}
