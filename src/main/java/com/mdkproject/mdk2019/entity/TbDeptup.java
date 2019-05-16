package com.mdkproject.mdk2019.entity;

import java.io.Serializable;

/**
 * tb_deptup
 * @author 
 */
public class TbDeptup implements Serializable {
    private Integer deptId;

    /**
     * 单位名称
     */
    private String deptName;

    /**
     * 单位征信代码
     */
    private String deptCode;

    /**
     * 单位图片
     */
    private String deptImgurl;

    /**
     * 审核单位
     */
    private String deptShenhe;

    /**
     * 审核单位编号
     */
    private String deptTjcode;

    private String createTime;

    private String updateTime;

    /**
     * 单位审核结果
     */
    private int status;

    private static final long serialVersionUID = 1L;

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

    public String getDeptImgurl() {
        return deptImgurl;
    }

    public void setDeptImgurl(String deptImgurl) {
        this.deptImgurl = deptImgurl;
    }

    public String getDeptShenhe() {
        return deptShenhe;
    }

    public void setDeptShenhe(String deptShenhe) {
        this.deptShenhe = deptShenhe;
    }

    public String getDeptTjcode() {
        return deptTjcode;
    }

    public void setDeptTjcode(String deptTjcode) {
        this.deptTjcode = deptTjcode;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", deptId=").append(deptId);
        sb.append(", deptName=").append(deptName);
        sb.append(", deptCode=").append(deptCode);
        sb.append(", deptImgurl=").append(deptImgurl);
        sb.append(", deptShenhe=").append(deptShenhe);
        sb.append(", deptTjcode=").append(deptTjcode);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}