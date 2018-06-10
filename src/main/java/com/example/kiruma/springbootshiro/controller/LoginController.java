package com.example.kiruma.springbootshiro.controller;


import com.example.kiruma.springbootshiro.bean.User;
import com.example.kiruma.springbootshiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {


    //登陆页面
    @RequestMapping(method = RequestMethod.GET)
    public String login(){
        return "login";
    }


    //登陆检验逻辑
    @RequestMapping(value = "/check",method = RequestMethod.POST)
    public String check(String username,String password){

        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        org.apache.shiro.subject.Subject subject= SecurityUtils.getSubject();

        try {
            subject.login(token);
            return "index"; //认证成功跳转到成功页面
        }catch (Exception e){
            e.printStackTrace();
            return "unauthenticatedPage";   //不成功跳转到 未认证页面
        }
    }

}
