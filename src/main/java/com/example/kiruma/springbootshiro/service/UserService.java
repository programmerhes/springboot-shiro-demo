package com.example.kiruma.springbootshiro.service;

import com.example.kiruma.springbootshiro.bean.User;

import java.util.List;


public interface UserService {

    User selectUserByUsername(String name);

    List<String> getUserPermissionByUserName(String username);


}
