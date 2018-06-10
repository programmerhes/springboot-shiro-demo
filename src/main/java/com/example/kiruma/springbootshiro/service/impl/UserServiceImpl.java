package com.example.kiruma.springbootshiro.service.impl;

import com.example.kiruma.springbootshiro.bean.User;
import com.example.kiruma.springbootshiro.dao.UserDao;
import com.example.kiruma.springbootshiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User selectUserByUsername(String name) {
        return userDao.selectUserByUsername(name);
    }

    @Override
    public List<String> getUserPermissionByUserName(String username) {
        return userDao.getUserPermissionByUserName(username);
    }
}
