package com.mdkproject.mdk2019.controller;


import com.mdkproject.mdk2019.entity.TbPublicinfo;
import com.mdkproject.mdk2019.response.CommonReturnType;
import com.mdkproject.mdk2019.services.PublicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowCredentials = "true")
@RequestMapping("/publicinfo")
public class PubInfoController {
    @Autowired
    private PublicInfoService publicInfoService;

    @GetMapping("/getinfo")
    public CommonReturnType findthreeinfo(){
        List<TbPublicinfo> list=publicInfoService.findthreeinfo();
        if(list!=null) {
            return CommonReturnType.createCommonReturnType(list);
        }else {
            return CommonReturnType.createCommonReturnType("信息错误","fail");
        }
    }
}
