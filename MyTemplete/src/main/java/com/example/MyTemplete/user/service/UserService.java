package com.example.MyTemplete.user.service;

import com.example.MyTemplete.user.dao.UserDAO;
import com.example.MyTemplete.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    // 로그인 기능
    public UserDTO login(String userId, String userPassword) {
        UserDTO user = userDAO.getUserById(userId);
        if (user != null && passwordEncoder.matches(userPassword, user.getUserPassword())) {
            return user;
        } else {
            return null;
        }
    }
    
    // 회원가입 기능
    public void join(UserDTO user) {
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        userDAO.saveUser(user);
    }

    public UserDTO getUserById(String userId) {
        return userDAO.getUserById(userId);
    }
}
