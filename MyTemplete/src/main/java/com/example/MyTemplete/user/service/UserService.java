package com.example.MyTemplete.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MyTemplete.user.dao.UserDAO;
import com.example.MyTemplete.user.model.UserVO;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public UserVO getUserById(String userId) {
        return userDAO.getUserById(userId);
    }
}