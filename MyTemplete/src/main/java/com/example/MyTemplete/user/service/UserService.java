package com.example.MyTemplete.user.service;

import com.example.MyTemplete.user.dao.UserDAO;
import com.example.MyTemplete.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public UserDTO login(String userId, String userPassword) {
        UserDTO user = userDAO.getUserById(userId);
        if (user != null && user.getUserPassword().equals(userPassword)) {
            return user;
        } else {
            return null;
        }
    }
}