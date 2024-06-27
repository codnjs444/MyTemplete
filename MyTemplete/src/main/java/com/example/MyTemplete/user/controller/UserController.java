package com.example.MyTemplete.user.controller;

import com.example.MyTemplete.user.dto.UserDTO;
import com.example.MyTemplete.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO user) {
        UserDTO loggedInUser = userService.login(user.getUserId(), user.getUserPassword());
        if (loggedInUser != null) {
            return ResponseEntity.ok(loggedInUser);
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}