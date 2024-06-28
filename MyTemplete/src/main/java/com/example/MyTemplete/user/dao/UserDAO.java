package com.example.MyTemplete.user.dao;

import com.example.MyTemplete.user.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO {
	
	// userId 값으로 user값 가져오기
    UserDTO getUserById(String userId);
    
    // 회원가입
    void saveUser(UserDTO user);
}
