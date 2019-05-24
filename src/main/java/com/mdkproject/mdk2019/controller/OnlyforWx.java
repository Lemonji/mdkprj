package com.mdkproject.mdk2019.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mdkproject.mdk2019.response.CommonReturnType;
import com.mdkproject.mdk2019.services.HearthCardService;
import com.mdkproject.mdk2019.services.TijianInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/forwx")
@RestController
@CrossOrigin(origins = "*",allowCredentials = "true")
public class OnlyforWx {

    @Autowired
    private TijianInfoService tijianInfoService;

    @Autowired
    private HearthCardService hearthCardService;

    //返回给小程序体检审核状体和健康证状态
    @PostMapping("/getstatus")
    public CommonReturnType getstatus(@RequestBody String idnum){
        System.out.println("微信请求来了");
        JSONObject js= JSON.parseObject(idnum);
        String tjstatus=tijianInfoService.gettjstatus(js.getString("idnum"));
        String hcstatus=hearthCardService.gettjstatus(js.getString("idnum"));
        if(tjstatus!=null&hcstatus!=null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("tjstatus", tjstatus);
            jsonObject.put("hcstatus", hcstatus);
            return CommonReturnType.createCommonReturnType(jsonObject);
        }else {
            return CommonReturnType.createCommonReturnType("argserr","fail");
        }
    }

}
