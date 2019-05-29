package com.mdkproject.mdk2019.controller;

import com.mdkproject.mdk2019.controller.viewobject.UserInfoVO;
import com.mdkproject.mdk2019.error.BusinessException;
import com.mdkproject.mdk2019.error.EmBusinessError;
import com.mdkproject.mdk2019.response.CommonReturnType;
import com.mdkproject.mdk2019.services.UserService;
import com.mdkproject.mdk2019.services.model.UserInfoModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @Auther: Liberal-World
 * @Date: 2019-04-10 09:30
 * @Description: 用户模块&账号登录加密狗验证
 * @Version 1.0
 */

@Controller
@RequestMapping("/user")
@CrossOrigin(origins = "*",allowCredentials = "true")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private HttpServletRequest request;

    //用户登录
    @RequestMapping(value = "login",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType login(@RequestParam(name = "account")String account,
                                  @RequestParam(name = "password")String password) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {

        //入参非空
        if (StringUtils.isEmpty(account) || StringUtils.isEmpty(password)){
            throw new BusinessException(EmBusinessError.USER_LOGIN_FAIL);
        }
        //校验登录
        UserInfoModel userInfoModel = userService.validateLogin(account, password);

        //将登录凭证加入到用户登录成功的session内

        //返回给前端
        UserInfoVO userInfoVO = this.convertUserInfoVOFromUserInfoModel(userInfoModel);
        return CommonReturnType.createCommonReturnType(userInfoVO);
    }

    //返回给前端
    private UserInfoVO convertUserInfoVOFromUserInfoModel(UserInfoModel userInfoModel){
        UserInfoVO userInfoVO = new UserInfoVO();
        BeanUtils.copyProperties(userInfoModel,userInfoVO);
        return userInfoVO;
    }


}
