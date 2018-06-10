package com.example.kiruma.springbootshiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class Test {

    @org.junit.Test
    public void test(){
        Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro/shiro.ini");

        SecurityManager securityManager=factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);  //设置好securityManager
        Subject subject= SecurityUtils.getSubject();         //取得subject，subject和securityManager关联起来

        UsernamePasswordToken token=new UsernamePasswordToken("zhang","123");
        try{
            subject.login(token);  //code和subject进行交互，subject委托securityManager
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("结果"+subject.isAuthenticated());
        subject.logout();
        System.out.println("结果"+subject.isAuthenticated());

    }
}
