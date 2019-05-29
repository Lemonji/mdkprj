package com.mdkproject.mdk2019.services.impl;

import com.mdkproject.mdk2019.dao.TijianInfoMapper;
import com.mdkproject.mdk2019.entity.TijianInfo;
import com.mdkproject.mdk2019.error.BusinessException;
import com.mdkproject.mdk2019.error.EmBusinessError;
import com.mdkproject.mdk2019.services.TijianInfoService;
import com.mdkproject.mdk2019.services.model.TijianModel;
import com.mdkproject.mdk2019.utils.DateToUtil;
import com.mdkproject.mdk2019.utils.MyTools;
import com.mdkproject.mdk2019.utils.SimpledateUtil;
import com.mdkproject.mdk2019.validator.ValidationResult;
import com.mdkproject.mdk2019.validator.ValidatorImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther: Liberal-World
 * @Date: 2019-04-11 10:15
 * @Description:体检信息基础录入
 * @Version 1.0
 */

@Service
public class TijianInfoServiceImpl implements TijianInfoService {


    @Autowired
    private TijianInfoMapper tijianInfoMapper;
    @Autowired
    private ValidatorImpl validator;

    //添加
    @Override
    public TijianModel save(TijianModel tijianModel) throws BusinessException {
        //入参校验
        ValidationResult result = validator.validate(tijianModel);
        if (result.isHasErrors()){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,result.getErrMsg());
        }

        tijianModel.setCreateTime(MyTools.getTime());
        tijianModel.setUpdateTime(MyTools.getTime());

        //入库之间去重判断当前日期-第一次办证日期>1年
        String idcardNum = tijianModel.getIdcardNum();
        TijianInfo tijianInfo1 = tijianInfoMapper.selectByIdCard(idcardNum);
        if (tijianInfo1 != null){
            String startdate = tijianInfo1.getStartdate();                  //第一办证时间
            String newDate = DateToUtil.getStringDateShort();               //现在时间
            Long aLong = DateToUtil.between_days(startdate, newDate);       //两者时间差
            if (aLong<365){
                throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"健康证还在有限期内");
            }
        }else{
            //model  --->entity
            TijianInfo tijianInfo = this.convertTijianInfoFromTijianMode(tijianModel);
            //入库
            tijianInfoMapper.insertSelective(tijianInfo);
            tijianModel.setTjId(tijianInfo.getTjId());
        }
        return this.getTjById(tijianModel.getTjId());

    }

    //详情
    @Override
    public TijianModel getTjById(Integer tjId) {
        TijianInfo tijianInfo = tijianInfoMapper.selectByPrimaryKey(tjId);
        if (tijianInfo==null){
            return null;
        }
        TijianModel tijianModel = this.convertTijianModelFromTijianInfo(tijianInfo);
        return tijianModel;
    }

    //列表
    @Override
    public List<TijianModel> listTijian() {
        List<TijianInfo> tijianInfoList = tijianInfoMapper.listTjInfo();
        //使用stream api 将list内的entity转化为model
        List<TijianModel> tijianModelList = tijianInfoList.stream().map(tijianInfo -> {
            TijianModel tijianModel = this.convertTijianModelFromTijianInfo(tijianInfo);
            return tijianModel;
        }).collect(Collectors.toList());
        return tijianModelList;
    }

    //时间段检索
    @Override
    public List<TijianModel> selectByStartToEnd(String startTime, String endTime) {
        List<TijianInfo> tijianInfoList = tijianInfoMapper.selectByStartToEnd(startTime, endTime);
        //使用steam api 将list内的entity -- model
        List<TijianModel> tijianModelList = tijianInfoList.stream().map(tijianInfo -> {
            TijianModel tijianModel = this.convertTijianModelFromTijianInfo(tijianInfo);
            return tijianModel;
        }).collect(Collectors.toList());
        return tijianModelList;
    }

    @Override
    public List findbycondition(Map condition) {
        return tijianInfoMapper.findbycondition(condition);
    }

    @Override
    public int updateStatus(String number, int status) {
        return tijianInfoMapper.updateStatus(number,status);
    }

    @Override
    public int daytjnum() {
        String createtime= SimpledateUtil.getSimpledate();
        return tijianInfoMapper.daytjnum(createtime);
    }

    @Override
    public int monthtjnum() {
        String nowdate=SimpledateUtil.getMonth();
        nowdate+="-01";
        return tijianInfoMapper.monthtjnum(nowdate);
    }

    @Override
    public int alltjnum() {
        return tijianInfoMapper.alltjnum();
    }

    @Override
    public List<TijianInfo> weektjnum() {

        return tijianInfoMapper.weektjnum();
    }

    @Override
    public List<TijianInfo> findtjporj(Map conditions) {
        return tijianInfoMapper.findtjporj(conditions);
    }

    public TijianInfo getlastnum(){
        return tijianInfoMapper.getlastnum();
    }

    @Override
    public List<TijianModel> daytjlist(String daytime) {
        List<TijianInfo> tijianInfoList = tijianInfoMapper.daytjlist(daytime);
        //使用steam api 将list内的entity -- model
        List<TijianModel> tijianModelList = tijianInfoList.stream().map(tijianInfo -> {
            TijianModel tijianModel = this.convertTijianModelFromTijianInfo(tijianInfo);
            return tijianModel;
        }).collect(Collectors.toList());
        return tijianModelList;
    }

    @Override
    public String gettjstatus(String idnum) {
        return tijianInfoMapper.gettjstatus(idnum);
    }


    //model--entity
    private TijianInfo convertTijianInfoFromTijianMode(TijianModel tijianModel){
        if (tijianModel==null){
            return null;
        }
        TijianInfo tijianInfo = new TijianInfo();
        BeanUtils.copyProperties(tijianModel,tijianInfo);
        return tijianInfo;
    }

    //entity-model
    private TijianModel convertTijianModelFromTijianInfo(TijianInfo tijianInfo){
        if (tijianInfo==null){
            return null;
        }
        TijianModel tijianModel = new TijianModel();
        BeanUtils.copyProperties(tijianInfo,tijianModel);
        return tijianModel;
    }

  public static void main(String[] args) {
      Date date=new Date();
      SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
      GregorianCalendar gc=new GregorianCalendar();
      gc.setTime(date);
      gc.add(3,-1);
      Date lastweek=gc.getTime();
      String sf=sdf.format(lastweek);
      System.out.println(sf);
  }


    public int getzerostatus(){
        return tijianInfoMapper.getzerostatus();
    }
    public int getonestatus(){
        return tijianInfoMapper.getonestatus();
    }
    public int getotwostatus(){
        return tijianInfoMapper.getotwostatus();
    }

    public List<TijianInfo> getzerolist(){
        return tijianInfoMapper.getzerolist();
    }
    public List<TijianInfo> getonelist(){
        return tijianInfoMapper.getonelist();
    }
    public List<TijianInfo> gettwolist(){
        return tijianInfoMapper.gettwolist();
    }

    public int updatehospital(String str,String hospitalname){
        return tijianInfoMapper.updatehospital(str,hospitalname);
    }

    public int deletetjinfo(String str){
        return tijianInfoMapper.deletetjinfo(str);
    }

}
