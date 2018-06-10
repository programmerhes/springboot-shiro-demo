package com.example.kiruma.springbootshiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ad")
public class AdController {


    @RequestMapping("/show")
    public String show(){
        return "ad-show";
    }
    @RequestMapping("/create")
    public String create(){
        return "ad-create";
    }
}
