package com.mdkproject.mdk2019.entity;

import javax.persistence.Transient;

public class TijianInfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_tijianinfo.tj_id
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    private Integer tjId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_tijianinfo.number
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    private String number;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_tijianinfo.telphone
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    private String telphone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_tijianinfo.name
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_tijianinfo.sex
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    private String sex;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_tijianinfo.age
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    private Integer age;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_tijianinfo.idcard_num
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    private String idcardNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_tijianinfo.hearthcard_num
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    private String hearthcardNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_tijianinfo.company
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    private String company;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_tijianinfo.adress
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    private String adress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_tijianinfo.idcard_phtoto
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    private String idcardPhtoto;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_tijianinfo.startdate
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    private String startdate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_tijianinfo.enddate
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    private String enddate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_tijianinfo.person
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    private String person;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_tijianinfo.dept_num
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    private String deptNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_tijianinfo.create_time
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    private String createTime;

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_tijianinfo.update_time
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    private String updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_tijianinfo.tj_id
     *
     * @return the value of tb_tijianinfo.tj_id
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    public Integer getTjId() {
        return tjId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_tijianinfo.tj_id
     *
     * @param tjId the value for tb_tijianinfo.tj_id
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    public void setTjId(Integer tjId) {
        this.tjId = tjId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_tijianinfo.number
     *
     * @return the value of tb_tijianinfo.number
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    public String getNumber() {
        return number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_tijianinfo.number
     *
     * @param number the value for tb_tijianinfo.number
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_tijianinfo.telphone
     *
     * @return the value of tb_tijianinfo.telphone
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    public String getTelphone() {
        return telphone;
    }

    @Transient
    private String hospitalName;

    @Transient
    private String healcardcreatTime;

    @Transient
    private String healthTime;

    @Transient
    private String medical;

    @Transient
    private int daycount;

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHealcardcreatTime() {
        return healcardcreatTime;
    }

    public void setHealcardcreatTime(String healcardcreatTime) {
        this.healcardcreatTime = healcardcreatTime;
    }

    public int getDaycount() {
        return daycount;
    }

    public void setDaycount(int daycount) {
        this.daycount = daycount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_tijianinfo.telphone
     *
     * @param telphone the value for tb_tijianinfo.telphone
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_tijianinfo.name
     *
     * @return the value of tb_tijianinfo.name
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_tijianinfo.name
     *
     * @param name the value for tb_tijianinfo.name
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }


    public String getHospitalname() {
        return hospitalName;
    }

    public void setHospitalname(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getCreatTime() {
        return healcardcreatTime;
    }

    public void setCreatTime(String healcardcreatTime) {
        this.healcardcreatTime = healcardcreatTime;
    }

    public String getHealthTime() {
        return healthTime;
    }

    public void setHealthTime(String healthTime) {
        this.healthTime = healthTime;
    }

    public String getMedical() {
        return medical;
    }

    public void setMedical(String medical) {
        this.medical = medical;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_tijianinfo.sex
     *
     * @return the value of tb_tijianinfo.sex
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_tijianinfo.sex
     *
     * @param sex the value for tb_tijianinfo.sex
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_tijianinfo.age
     *
     * @return the value of tb_tijianinfo.age
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_tijianinfo.age
     *
     * @param age the value for tb_tijianinfo.age
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_tijianinfo.idcard_num
     *
     * @return the value of tb_tijianinfo.idcard_num
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    public String getIdcardNum() {
        return idcardNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_tijianinfo.idcard_num
     *
     * @param idcardNum the value for tb_tijianinfo.idcard_num
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    public void setIdcardNum(String idcardNum) {
        this.idcardNum = idcardNum == null ? null : idcardNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_tijianinfo.hearthcard_num
     *
     * @return the value of tb_tijianinfo.hearthcard_num
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    public String getHearthcardNum() {
        return hearthcardNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_tijianinfo.hearthcard_num
     *
     * @param hearthcardNum the value for tb_tijianinfo.hearthcard_num
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    public void setHearthcardNum(String hearthcardNum) {
        this.hearthcardNum = hearthcardNum == null ? null : hearthcardNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_tijianinfo.company
     *
     * @return the value of tb_tijianinfo.company
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    public String getCompany() {
        return company;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_tijianinfo.company
     *
     * @param company the value for tb_tijianinfo.company
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_tijianinfo.adress
     *
     * @return the value of tb_tijianinfo.adress
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    public String getAdress() {
        return adress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_tijianinfo.adress
     *
     * @param adress the value for tb_tijianinfo.adress
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    public void setAdress(String adress) {
        this.adress = adress == null ? null : adress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_tijianinfo.idcard_phtoto
     *
     * @return the value of tb_tijianinfo.idcard_phtoto
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    public String getIdcardPhtoto() {
        return idcardPhtoto;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_tijianinfo.idcard_phtoto
     *
     * @param idcardPhtoto the value for tb_tijianinfo.idcard_phtoto
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    public void setIdcardPhtoto(String idcardPhtoto) {
        this.idcardPhtoto = idcardPhtoto == null ? null : idcardPhtoto.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_tijianinfo.startdate
     *
     * @return the value of tb_tijianinfo.startdate
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    public String getStartdate() {
        return startdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_tijianinfo.startdate
     *
     * @param startdate the value for tb_tijianinfo.startdate
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    public void setStartdate(String startdate) {
        this.startdate = startdate == null ? null : startdate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_tijianinfo.enddate
     *
     * @return the value of tb_tijianinfo.enddate
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    public String getEnddate() {
        return enddate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_tijianinfo.enddate
     *
     * @param enddate the value for tb_tijianinfo.enddate
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    public void setEnddate(String enddate) {
        this.enddate = enddate == null ? null : enddate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_tijianinfo.person
     *
     * @return the value of tb_tijianinfo.person
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    public String getPerson() {
        return person;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_tijianinfo.person
     *
     * @param person the value for tb_tijianinfo.person
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    public void setPerson(String person) {
        this.person = person == null ? null : person.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_tijianinfo.dept_num
     *
     * @return the value of tb_tijianinfo.dept_num
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    public String getDeptNum() {
        return deptNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_tijianinfo.dept_num
     *
     * @param deptNum the value for tb_tijianinfo.dept_num
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    public void setDeptNum(String deptNum) {
        this.deptNum = deptNum == null ? null : deptNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_tijianinfo.create_time
     *
     * @return the value of tb_tijianinfo.create_time
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_tijianinfo.create_time
     *
     * @param createTime the value for tb_tijianinfo.create_time
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_tijianinfo.update_time
     *
     * @return the value of tb_tijianinfo.update_time
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_tijianinfo.update_time
     *
     * @param updateTime the value for tb_tijianinfo.update_time
     *
     * @mbg.generated Fri Apr 12 11:23:31 CST 2019
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }
}