package com.mdkproject.mdk2019.controller;


import com.alibaba.fastjson.JSONObject;
import com.mdkproject.mdk2019.entity.DeptOrder;
import com.mdkproject.mdk2019.entity.HearthCard;
import com.mdkproject.mdk2019.entity.TijianInfo;
import com.mdkproject.mdk2019.response.CommonReturnType;
import com.mdkproject.mdk2019.services.DeptOrderService;
import com.mdkproject.mdk2019.services.HearthCardService;
import com.mdkproject.mdk2019.services.TijianInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tubiao")
@CrossOrigin(origins = {"*"},allowCredentials = "true")//解决跨域请求
public class OnlyforTuController {
    @Autowired
    private HearthCardService hearthCardService;

    @Autowired
    private TijianInfoService tijianInfoService;

    @Autowired
    private DeptOrderService deptOrderService;

    //体检首页面上分方框接口
    @GetMapping("/indexcount")
    public CommonReturnType indexcount(){
        JSONObject jsonObject=new JSONObject();
        int dayordernum=deptOrderService.dayordernum();
        int daycardnum=hearthCardService.daycardnum();
        int daytjnum=tijianInfoService.daytjnum();
        int monthtjnum=tijianInfoService.monthtjnum();
        int alltjnum=tijianInfoService.alltjnum();
        jsonObject.put("dayordernum",dayordernum);
        jsonObject.put("daycardnum",daycardnum);
        jsonObject.put("daytjnum",daytjnum);
        jsonObject.put("monthtjnum",monthtjnum);
        jsonObject.put("alltjnum",alltjnum);
        return CommonReturnType.createCommonReturnType(jsonObject);
    }

    //体检柱形图接口
    @GetMapping("/zhucountone")
    public CommonReturnType zhucount(){
        JSONObject jsonObject=new JSONObject();
        List<TijianInfo> tjdata=tijianInfoService.weektjnum();
        List<HearthCard> carddata=hearthCardService.weektjnum();
        for(int i=0;i<tjdata.size();i++){
            jsonObject.put("day"+i,tjdata.get(i).getCreateTime());
            jsonObject.put("tjdaynum"+i,tjdata.get(i).getDaycount());
            jsonObject.put("carddaynum"+i,carddata.get(i).getDaycount());
        }
        return CommonReturnType.createCommonReturnType(jsonObject);
    }

    @GetMapping("/zhucounttwo")
    public CommonReturnType zhucounttwo(){
        JSONObject jsonObject=new JSONObject();
        List<DeptOrder> orderdata=deptOrderService.weektjnum();
        for(int i=0;i<orderdata.size();i++){
            jsonObject.put("day"+i,orderdata.get(i).getCreateTime());
            jsonObject.put("ordernum"+i,orderdata.get(i).getDaycount());
        }
        return CommonReturnType.createCommonReturnType(jsonObject);
    }

    /*@GetMapping("/bingcount")
    public CommonReturnType bingcount(){


        return null;
    }*/

}
