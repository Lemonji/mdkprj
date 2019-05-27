package com.mdkproject.mdk2019.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mdkproject.mdk2019.controller.viewobject.TijianInfoVO;
import com.mdkproject.mdk2019.entity.TijianInfo;
import com.mdkproject.mdk2019.error.BusinessException;
import com.mdkproject.mdk2019.error.EmBusinessError;
import com.mdkproject.mdk2019.response.CommonReturnType;
import com.mdkproject.mdk2019.services.TijianInfoService;
import com.mdkproject.mdk2019.services.TijianProjectService;
import com.mdkproject.mdk2019.services.model.TijianModel;
import com.mdkproject.mdk2019.utils.SimpledateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther: Liberal-World
 * @Date: 2019-04-11 10:14
 * @Description: 体检信息基础录入
 * @Version 1.0
 */

@Controller
@RequestMapping("/tijian")
@CrossOrigin(origins = "*",allowCredentials = "true")
public class TijianInfoController {

    @Autowired
    private TijianInfoService tijianInfoService;

    @Autowired
    private TijianProjectService tjporj;

    JSONObject publicjson;


    //体检基础录入
    @RequestMapping(value = "/add",method = {RequestMethod.POST},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public CommonReturnType add(@RequestBody String str) throws BusinessException {
        System.out.println(str);
        JSONObject jsonObject= JSON.parseObject(str);
        int jssize = 0;
        for (String key : jsonObject.keySet()) {
            jssize++;
            if (jsonObject.get(key) == null
                    || jsonObject.get(key) == ""
                    || jsonObject.get(key).equals("")
                    || jsonObject.get(key).toString().trim().length() == 0) {
                //logger.info("出现了空字符串");
                jssize--;
            }
            //System.out.println(jssize);
        }
        if (jssize < 13) {
            return CommonReturnType.createCommonReturnType("参数有误","fail");
        }
        jsonObject.put("idcardPhtoto","whatever");
        System.out.println(jsonObject);
        String jsonstr=JSON.toJSONString(jsonObject);
        TijianModel formdata=JSON.parseObject(jsonstr,TijianModel.class);
        TijianModel tijianModel = tijianInfoService.save(formdata);
        return CommonReturnType.createCommonReturnType(formdata);
    }

    //体检信息详情
    @RequestMapping(value = "/get",method = {RequestMethod.GET},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public CommonReturnType get(@RequestParam(name = "tjId")Integer tjId){
        TijianModel tijianModel = tijianInfoService.getTjById(tjId);
        TijianInfoVO tijianInfoVO = this.convertTijianInfoVOFromTijianModel(tijianModel);
        return CommonReturnType.createCommonReturnType(tijianInfoVO);
    }

    //体检信息列表
    @RequestMapping(value = "/list",method = {RequestMethod.GET},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public CommonReturnType list(){
        List<TijianModel> tijianModelList = tijianInfoService.listTijian();

        //使用stream api 将list内的model ---> vo
        List<TijianInfoVO> tijianInfoVOList = tijianModelList.stream().map(tijianModel -> {
            TijianInfoVO tijianInfoVO = this.convertTijianInfoVOFromTijianModel(tijianModel);
            return tijianInfoVO;
        }).collect(Collectors.toList());
        return CommonReturnType.createCommonReturnType(tijianInfoVOList);
    }

    //时间段查询(起止时间检索)
    @RequestMapping(value = "/getDate",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType getDate(@RequestParam(name = "startTime")String startTime,
                                    @RequestParam(name = "endTime")String endTime) throws BusinessException {
        //入参非空校验
        if (StringUtils.isEmpty(startTime) || StringUtils.isEmpty(endTime)){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        //时间格式
        String newstartTime = startTime+"00:00:00";
        String newendTime = endTime+"59:59:59";

        List<TijianModel> tijianModelList = tijianInfoService.selectByStartToEnd(newstartTime, newendTime);
        //使用stream api 将list内的model ---> vo
        List<TijianInfoVO> tijianInfoVOList = tijianModelList.stream().map(tijianModel -> {
            TijianInfoVO tijianInfoVO = this.convertTijianInfoVOFromTijianModel(tijianModel);
            return tijianInfoVO;
        }).collect(Collectors.toList());
        return CommonReturnType.createCommonReturnType(tijianInfoVOList);
    }

    //快速录入


    //改变体检审核的结果，新增的默认都是未审核
    @PostMapping("/upstatus")
    @ResponseBody
    public CommonReturnType updatetjstatus(@RequestBody String str){
        System.out.println(str);
        JSONObject jsonObject=new JSONObject();
        jsonObject=JSON.parseObject(str);
        String number=jsonObject.getString("number");
        int status=jsonObject.getInteger("status");
        return CommonReturnType.createCommonReturnType(tijianInfoService.updateStatus(number,status));
    }

    //查询体检未审核，审核通过，审核未通过的结果
    @GetMapping("/getallstatus")
    @ResponseBody
    public CommonReturnType getallstatus(){
        JSONObject jsonObject=new JSONObject();
        int zerostatus=tijianInfoService.getzerostatus();
        int onestatus=tijianInfoService.getonestatus();
        int otwostatus=tijianInfoService.getotwostatus();
        jsonObject.put("zerostatus",zerostatus);
        jsonObject.put("onestatus",onestatus);
        jsonObject.put("otwostatus",otwostatus);
        return CommonReturnType.createCommonReturnType(jsonObject);
    }

    //体检未审核人员列表
    @GetMapping("/getzerolist")
    @ResponseBody
    public CommonReturnType getzerolist(){
        return CommonReturnType.createCommonReturnType(tijianInfoService.getzerolist());
    }

    //体检审核通过人员列表
    @GetMapping("/getonelist")
    @ResponseBody
    public CommonReturnType getonelist(){
        return CommonReturnType.createCommonReturnType(tijianInfoService.getonelist());
    }


    //体检审核不通过人员列表
    @GetMapping("/gettwolist")
    @ResponseBody
    public CommonReturnType gettwolist(){
        return CommonReturnType.createCommonReturnType(tijianInfoService.gettwolist());
    }


    //返回给前端model-vo
    private TijianInfoVO convertTijianInfoVOFromTijianModel(TijianModel tijianModel){
        if (tijianModel==null){
            return null;
        }
        TijianInfoVO tjvo = new TijianInfoVO();
        BeanUtils.copyProperties(tijianModel,tjvo);
        return tjvo;
    }

    //多条件查询
    @PostMapping("/getbycond")
    @ResponseBody
    public CommonReturnType findbycond(@RequestBody Map conditions){
        return CommonReturnType.createCommonReturnType(tijianInfoService.findbycondition(conditions));
    }


    //查询当日体检人数
    @GetMapping("/daytjnum")
    @ResponseBody
    public CommonReturnType daytjnum(){
    //System.out.println("有请求来了");
        return CommonReturnType.createCommonReturnType(tijianInfoService.daytjnum());
    }

    //查询当月体检人数
    @GetMapping("/monthtjnum")
    @ResponseBody
    public CommonReturnType monthtjnum(){
        return CommonReturnType.createCommonReturnType(tijianInfoService.monthtjnum());
    }


    //查询体检总人数
    @GetMapping("/alltjnum")
    @ResponseBody
    public CommonReturnType alltjnum(){
        return CommonReturnType.createCommonReturnType(tijianInfoService.alltjnum());
    }


    //查询最近一周体检人数
    @GetMapping("/weektjnum")
    @ResponseBody
    public CommonReturnType weektjnum(){
        return CommonReturnType.createCommonReturnType(tijianInfoService.weektjnum());
    }


    //从业人员健康检查表
    @PostMapping("/tjproj")
    @ResponseBody
    public CommonReturnType tjproj(@RequestBody Map conditions){
        List alllist=new ArrayList();
        Map map=new HashMap();
        List<TijianInfo> tjinfolist= tijianInfoService.findtjporj(conditions);
        if(tjinfolist!=null) {
            for (TijianInfo idcard : tjinfolist) {
                try {
                    map = tjporj.findByIdcard(idcard.getIdcardNum());
                    alllist.add(idcard);
                    alllist.add(map);
                } catch (BusinessException e) {
                    e.printStackTrace();
                }
            }
        }else{
            System.out.println("没有数据");
        }
        return CommonReturnType.createCommonReturnType(alllist);
    }


    //查询体检表最后一条记录的体检编号
    @GetMapping("/getlastnum")
    @ResponseBody
    public CommonReturnType getlastnum(){
        TijianInfo lastnum=tijianInfoService.getlastnum();
        return CommonReturnType.createCommonReturnType(lastnum);
    }

    //刷新页面的时候重新给下面表格数据
    @PostMapping("/weektjlist")
    @ResponseBody
    public CommonReturnType weektjlist(){
       //String daytime=SimpledateUtil.getSimpledate();
       GregorianCalendar gc=new GregorianCalendar();
       gc.setTime(new Date());
       gc.add(5,-7);
       Date lastweek=gc.getTime();
       String daytime=SimpledateUtil.getSimpledate(lastweek);
        List list=tijianInfoService.daytjlist(daytime);
        return CommonReturnType.createCommonReturnType(list);
    }

    //打印体检表的时候获取传过来的参数
    @PostMapping("/tjtable")
    @ResponseBody
    public CommonReturnType tjbiao(@RequestBody String str) throws BusinessException {
        System.out.println(str);
        publicjson= JSON.parseObject(str);
        int jssize = 0;
        for (String key : publicjson.keySet()) {
            jssize++;
            if (publicjson.get(key) == null
                    || publicjson.get(key) == ""
                    || publicjson.get(key).equals("")
                    || publicjson.get(key).toString().trim().length() == 0) {
                //logger.info("出现了空字符串");
                jssize--;
            }
            //System.out.println(jssize);
        }
        if (jssize < 9) {
            return CommonReturnType.createCommonReturnType("参数有误","fail");
        }
        return CommonReturnType.createCommonReturnType("success");
    }

    //将获取到的数据传给体检表页面
    @GetMapping("/gettjtable")
    @ResponseBody
    public CommonReturnType gettjbiaoinfo(){
        if(publicjson!=null) {
            return CommonReturnType.createCommonReturnType(publicjson);
        }
        else {return CommonReturnType.createCommonReturnType("获取失败","fail");}
    }

}
