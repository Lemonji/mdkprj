/*
package com.mdkproject.mdk2019.Shiro;

import com.mdkproject.mdk2019.dao.UserInfoMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm {
    @Autowired
    private UserInfoMapper userMapper;

    */
/**
     * 获取身份验证信息
     * shiro中，最终是通过realm来获取应用程序中的用户、角色权限信息的
     * @param authenticationToken 用户身份信息token
     * @return 返回封装了用户信息的 AuthenticationInfo 实例
     *//*

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("身份认证方法");
        UsernamePasswordToken token=(UsernamePasswordToken)authenticationToken;
        //从数据库获取对应用户密码的用户
        String password=userMapper.getUserPassword(token.getUsername());
        if(null==password){
            throw new AccountException("用户名不正确");
        }else if(!password.equals(new String((char[])token.getCredentials()))){
            System.out.println("数据库密码"+password);
            System.out.println("shiro密码"+new String((char[])token.getCredentials()));
            throw new AccountException("密码不正确");
        }
        return new SimpleAuthenticationInfo(token.getPrincipal(),password,getName());
    }


    */
/**
     * 获取授权信息
     * @param principalCollection
     * @return
     *//*

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("权限认证");
        String username=(String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        //获取该用户角色
        String role=userMapper.getRole(username);
        Set<String> set=new HashSet<>();
        //需要将role封装到set作为info.setRoles()的参数
        set.add(role);
        //设置该用户拥有的角色
        info.setRoles(set);
        return info;
    }
}
*/
