package com.example.MyTemplete.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.MyTemplete.user.model.UserVO;
import com.example.MyTemplete.user.service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public UserVO getUserById(@RequestParam String userId) {
        return userService.getUserById(userId);
    }
}