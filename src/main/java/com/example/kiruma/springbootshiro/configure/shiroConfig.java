package com.example.kiruma.springbootshiro.configure;


import com.example.kiruma.springbootshiro.realm.MyRealm;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.Map;


@Configuration
public class shiroConfig {

    @Resource(name="myRealm")
    MyRealm myRealm;
    /**
     * 拦截器
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        System.out.println("shiro 配置 filter");
        ShiroFilterFactoryBean shiroFilterFactoryBean =new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
        filterChainDefinitionMap.put("/static/**","anon"); //静态资源一律放行
        filterChainDefinitionMap.put("/login","anon");     //login页面无需认证
        filterChainDefinitionMap.put("/login/check","anon");//login check也不用认证

        //与广告相关的路径的规则
        filterChainDefinitionMap.put("/ad","authc");//需要认证
        filterChainDefinitionMap.put("/ad/show","authc,perms[ad:show]");//需要授权
        filterChainDefinitionMap.put("/ad/create","authc,perms[ad:create]");//需要授权




        filterChainDefinitionMap.put("/**","authc");//剩下的也都要授权
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorizedPage");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return  shiroFilterFactoryBean;

    }


    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm);
        return securityManager;
    }


}
