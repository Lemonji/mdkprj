package com.mdkproject.mdk2019.entity;

import java.io.Serializable;

/**
 * tb_machinecode
 * @author 
 */
public class TbMachinecode implements Serializable {
    private Integer id;

    /**
     * 机器码
     */
    private String machinecode;

    /**
     * 0代表未激活，1代表试用期，2代表正式版，3代表过期，4代表停用
     */
    private Integer status;

    /**
     * 激活时间
     */
    private String activetime;

    /**
     * 激活单位
     */
    private String activedept;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMachinecode() {
        return machinecode;
    }

    public void setMachinecode(String machinecode) {
        this.machinecode = machinecode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getActivetime() {
        return activetime;
    }

    public void setActivetime(String activetime) {
        this.activetime = activetime;
    }

    public String getActivedept() {
        return activedept;
    }

    public void setActivedept(String activedept) {
        this.activedept = activedept;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TbMachinecode other = (TbMachinecode) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMachinecode() == null ? other.getMachinecode() == null : this.getMachinecode().equals(other.getMachinecode()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getActivetime() == null ? other.getActivetime() == null : this.getActivetime().equals(other.getActivetime()))
            && (this.getActivedept() == null ? other.getActivedept() == null : this.getActivedept().equals(other.getActivedept()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMachinecode() == null) ? 0 : getMachinecode().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getActivetime() == null) ? 0 : getActivetime().hashCode());
        result = prime * result + ((getActivedept() == null) ? 0 : getActivedept().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", machinecode=").append(machinecode);
        sb.append(", status=").append(status);
        sb.append(", activetime=").append(activetime);
        sb.append(", activedept=").append(activedept);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}