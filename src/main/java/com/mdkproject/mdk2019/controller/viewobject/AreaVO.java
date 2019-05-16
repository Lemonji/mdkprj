package com.mdkproject.mdk2019.controller.viewobject;

/**
 * @Auther: Liberal-World
 * @Date: 2019-03-28 09:43
 * @Description:返回给前端的数据
 * @Version 1.0
 */
public class AreaVO {

    private Integer areaId;

    private String areaName;

    private String areaNum;

    private String createTime;

    private String createby;


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

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby;
    }
}
