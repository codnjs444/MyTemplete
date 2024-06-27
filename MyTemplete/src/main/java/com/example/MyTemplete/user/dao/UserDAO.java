package com.example.MyTemplete.user.dao;

import com.example.MyTemplete.user.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO {
    UserDTO getUserById(String userId);
}
