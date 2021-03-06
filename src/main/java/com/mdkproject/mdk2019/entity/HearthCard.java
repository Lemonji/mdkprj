package com.mdkproject.mdk2019.entity;

import javax.persistence.Transient;

public class HearthCard {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_hearth_card.health_id
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    private Integer healthId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_hearth_card.name
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_hearth_card.age
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    private Integer age;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_hearth_card.gender
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    private String gender;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_hearth_card.medical
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    private String medical;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_hearth_card.id_card
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    private String idCard;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_hearth_card.health_num
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    private String healthNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_hearth_card.health_time
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    private String healthTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_hearth_card.qr_code
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    private String qrCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_hearth_card.hospital_id
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    private String hospitalId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_hearth_card.create_time
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    private String createTime;

    @Transient
    private int daycount;

    public int getDaycount() {
        return daycount;
    }

    public void setDaycount(int daycount) {
        this.daycount = daycount;
    }

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_hearth_card.update_time
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    private String updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_hearth_card.createby
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    private String createby;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_hearth_card.health_id
     *
     * @return the value of tb_hearth_card.health_id
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    public Integer getHealthId() {
        return healthId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_hearth_card.health_id
     *
     * @param healthId the value for tb_hearth_card.health_id
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    public void setHealthId(Integer healthId) {
        this.healthId = healthId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_hearth_card.name
     *
     * @return the value of tb_hearth_card.name
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_hearth_card.name
     *
     * @param name the value for tb_hearth_card.name
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_hearth_card.age
     *
     * @return the value of tb_hearth_card.age
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_hearth_card.age
     *
     * @param age the value for tb_hearth_card.age
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_hearth_card.gender
     *
     * @return the value of tb_hearth_card.gender
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    public String getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_hearth_card.gender
     *
     * @param gender the value for tb_hearth_card.gender
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_hearth_card.medical
     *
     * @return the value of tb_hearth_card.medical
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    public String getMedical() {
        return medical;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_hearth_card.medical
     *
     * @param medical the value for tb_hearth_card.medical
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    public void setMedical(String medical) {
        this.medical = medical == null ? null : medical.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_hearth_card.id_card
     *
     * @return the value of tb_hearth_card.id_card
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_hearth_card.id_card
     *
     * @param idCard the value for tb_hearth_card.id_card
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_hearth_card.health_num
     *
     * @return the value of tb_hearth_card.health_num
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    public String getHealthNum() {
        return healthNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_hearth_card.health_num
     *
     * @param healthNum the value for tb_hearth_card.health_num
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    public void setHealthNum(String healthNum) {
        this.healthNum = healthNum == null ? null : healthNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_hearth_card.health_time
     *
     * @return the value of tb_hearth_card.health_time
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    public String getHealthTime() {
        return healthTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_hearth_card.health_time
     *
     * @param healthTime the value for tb_hearth_card.health_time
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    public void setHealthTime(String healthTime) {
        this.healthTime = healthTime == null ? null : healthTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_hearth_card.qr_code
     *
     * @return the value of tb_hearth_card.qr_code
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    public String getQrCode() {
        return qrCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_hearth_card.qr_code
     *
     * @param qrCode the value for tb_hearth_card.qr_code
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    public void setQrCode(String qrCode) {
        this.qrCode = qrCode == null ? null : qrCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_hearth_card.hospital_id
     *
     * @return the value of tb_hearth_card.hospital_id
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    public String getHospitalId() {
        return hospitalId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_hearth_card.hospital_id
     *
     * @param hospitalId the value for tb_hearth_card.hospital_id
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId == null ? null : hospitalId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_hearth_card.create_time
     *
     * @return the value of tb_hearth_card.create_time
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_hearth_card.create_time
     *
     * @param createTime the value for tb_hearth_card.create_time
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_hearth_card.update_time
     *
     * @return the value of tb_hearth_card.update_time
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_hearth_card.update_time
     *
     * @param updateTime the value for tb_hearth_card.update_time
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_hearth_card.createby
     *
     * @return the value of tb_hearth_card.createby
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    public String getCreateby() {
        return createby;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_hearth_card.createby
     *
     * @param createby the value for tb_hearth_card.createby
     *
     * @mbg.generated Mon Apr 22 09:37:56 CST 2019
     */
    public void setCreateby(String createby) {
        this.createby = createby == null ? null : createby.trim();
    }
}