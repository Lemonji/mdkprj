package com.mdkproject.mdk2019.services.impl;

import com.mdkproject.mdk2019.dao.UserInfoMapper;
import com.mdkproject.mdk2019.dao.UserRoleMapper;
import com.mdkproject.mdk2019.entity.UserInfo;
import com.mdkproject.mdk2019.entity.UserRole;
import com.mdkproject.mdk2019.error.BusinessException;
import com.mdkproject.mdk2019.error.EmBusinessError;
import com.mdkproject.mdk2019.services.UserService;
import com.mdkproject.mdk2019.services.model.UserInfoModel;
import com.mdkproject.mdk2019.utils.GetRandem;
import com.mdkproject.mdk2019.utils.MyMD5Util;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @Auther: Liberal-World
 * @Date: 2019-04-10 09:32
 * @Description:
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;


    //登录
    @Override
    public UserInfoModel validateLogin(String account, String password) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        //通过账号获取用户信息
        UserInfo userInfo = userInfoMapper.selectByaccount(account);
        if (userInfo==null){
            throw new BusinessException(EmBusinessError.USER_NOT_EXIT);
        }

        //原始密码和数据库加密码对比
        if (!MyMD5Util.validPassword(password, userInfo.getPassword())){
            throw new BusinessException(EmBusinessError.USER_LOGIN_FAIL);
        }
        //加密狗校验
        //1.获取加密狗序列号(-1没有检测到vikey,2vikey块多) 判断
        /*int viKeyByID = VikeyUtil.getViKeyByID();
        if (viKeyByID == -1){
            throw new BusinessException(EmBusinessError.VIKEY_NOT_EXIT);
        }
        if (viKeyByID == 2){
            throw new BusinessException(EmBusinessError.VIKEY_NOT_ERROR);
        }
        if (viKeyByID == 0){
            throw new BusinessException(EmBusinessError.VIKEY_NOT_CODE);
        }
        //2.vikey加密验证
        if (!MyMD5Util.validPassword(String.valueOf(viKeyByID), userInfo.getViKey())){
            throw new BusinessException(EmBusinessError.VIKEY_ERROR);
        }
*/
        //权限信息
        UserRole userRole = userRoleMapper.selectByPrimaryKey(Integer.valueOf(userInfo.getRoleId()));
        if (userRole==null){
            throw new BusinessException(EmBusinessError.ROLE_NOT_EXIT);
        }

        UserInfoModel userInfoModel = this.convertUserInfoModelFromUserInfo(userInfo);
        userInfoModel.setToken(GetRandem.getDateR());
        return userInfoModel;
    }





    //entity ---> model 模型转换
    private UserInfoModel convertUserInfoModelFromUserInfo(UserInfo userInfo){
        UserInfoModel userInfoModel = new UserInfoModel();
        BeanUtils.copyProperties(userInfo,userInfoModel);
        return userInfoModel;
    }

}
