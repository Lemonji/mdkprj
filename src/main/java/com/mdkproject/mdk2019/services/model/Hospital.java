package com.mdkproject.mdk2019.services.model;

/**
 * @Auther: Liberal-World
 * @Date: 2019-04-01 10:33
 * @Description:体检机构
 * @Version 1.0
 */
public class Hospital {

    private String hospitalId;          //id
    private String hospitalName;        //机构名称
    private String hospitalNum;         //体检机构编号
    private String hospitalGz;          //体检机构公章
    private String hospitalProvince;
    private String hospitalCity;
    private String hospitalDistrict;
    private String hospitalAddress;     //机构地址
    private String hospitalTelphone;    //电话
    private String areaNum;             //区域编号
    private String createTime;
    private String updateTime;

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalNum() {
        return hospitalNum;
    }

    public void setHospitalNum(String hospitalNum) {
        this.hospitalNum = hospitalNum;
    }

    public String getHospitalGz() {
        return hospitalGz;
    }

    public void setHospitalGz(String hospitalGz) {
        this.hospitalGz = hospitalGz;
    }

    public String getHospitalProvince() {
        return hospitalProvince;
    }

    public void setHospitalProvince(String hospitalProvince) {
        this.hospitalProvince = hospitalProvince;
    }

    public String getHospitalCity() {
        return hospitalCity;
    }

    public void setHospitalCity(String hospitalCity) {
        this.hospitalCity = hospitalCity;
    }

    public String getHospitalDistrict() {
        return hospitalDistrict;
    }

    public void setHospitalDistrict(String hospitalDistrict) {
        this.hospitalDistrict = hospitalDistrict;
    }

    public String getHospitalAddress() {
        return hospitalAddress;
    }

    public void setHospitalAddress(String hospitalAddress) {
        this.hospitalAddress = hospitalAddress;
    }

    public String getHospitalTelphone() {
        return hospitalTelphone;
    }

    public void setHospitalTelphone(String hospitalTelphone) {
        this.hospitalTelphone = hospitalTelphone;
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
}
