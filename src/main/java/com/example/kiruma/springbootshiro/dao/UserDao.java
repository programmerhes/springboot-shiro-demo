package com.example.kiruma.springbootshiro.dao;

import com.example.kiruma.springbootshiro.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {

    User selectUserByUsername(@Param("name") String name);

    List<String> getUserPermissionByUserName(@Param("username") String username);

}
