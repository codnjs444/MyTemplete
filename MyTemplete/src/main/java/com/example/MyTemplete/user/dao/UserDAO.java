package com.example.MyTemplete.user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.MyTemplete.user.model.UserVO;

@Mapper
public interface UserDAO {
    UserVO getUserById(String userId);
}