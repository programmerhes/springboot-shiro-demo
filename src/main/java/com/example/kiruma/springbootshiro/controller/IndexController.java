package com.example.kiruma.springbootshiro.controller;


import com.example.kiruma.springbootshiro.bean.User;
import com.example.kiruma.springbootshiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {


    //未授权跳转页面
    @RequestMapping("/unauthorizedPage")
    public String index(){
        return "unauthorizedPage";
    }
}
