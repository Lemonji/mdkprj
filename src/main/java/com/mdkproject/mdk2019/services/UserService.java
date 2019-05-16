package com.mdkproject.mdk2019.services;

import com.mdkproject.mdk2019.error.BusinessException;
import com.mdkproject.mdk2019.services.model.UserInfoModel;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public interface UserService {

    //用户注册


    //用户登录
    UserInfoModel validateLogin(String account, String encrptPassword) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException;


}
