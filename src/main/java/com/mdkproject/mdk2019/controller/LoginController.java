package com.mdkproject.mdk2019.controller;

import com.mdkproject.mdk2019.response.CommonReturnType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @RequestMapping("/notLogin")
    public CommonReturnType notLogin(){
        return CommonReturnType.createCommonReturnType("尚未登录","fail");
    }

    @RequestMapping("/notRole")
    public CommonReturnType notRole(){
        return CommonReturnType.createCommonReturnType("没有权限","fail");
    }
}
