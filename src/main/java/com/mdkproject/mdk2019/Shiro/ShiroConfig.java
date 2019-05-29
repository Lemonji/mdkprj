/*
package com.mdkproject.mdk2019.Shiro;


import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean= new ShiroFilterFactoryBean();
        //设置SecurityManager
        shiroFilterFactoryBean.setSecurityManager((securityManager));
        //设置未登陆的时候跳转的页面
        //setLoginUrl不设置的时候，会寻找/login.jsp或/login的映射
        shiroFilterFactoryBean.setLoginUrl("/login/notLogin");
        //设置无权限时跳转的url
        shiroFilterFactoryBean.setUnauthorizedUrl("/login/notRole");

        //设置拦截器
        Map<String,String> filterChainDefinitionMap=new LinkedHashMap<>();
        //用户，需要角色权限"user"
        //filterChainDefinitionMap.put("/user/**","roles[user]");
        //管理员，需要角色权限"admin"
        filterChainDefinitionMap.put("/tijian/**","roles[admin]");
        //开放登录接口
        filterChainDefinitionMap.put("/user/login","anon");
        //其余接口一律拦截
        //主要这行代码必须放在所有权限设置的最后，不然会导致所有url被拦截
        filterChainDefinitionMap.put("/**","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        System.out.println("shiro拦截器工厂类注入成功");
        return  shiroFilterFactoryBean;
    }

    */
/**
     * 注入sercurityManager
     *//*

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        //设置realm
        securityManager.setRealm(customRealm());
        return securityManager;
    }

    */
/**
     * 自定义身份认证realm
     *//*

    @Bean
    public CustomRealm customRealm(){
        return new CustomRealm();
    }
}
*/
