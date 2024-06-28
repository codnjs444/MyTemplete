package com.example.MyTemplete.user.controller;

import com.example.MyTemplete.config.jwt.JwtTokenProvider;
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
    
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO user) {
        UserDTO loggedInUser = userService.login(user.getUserId(), user.getUserPassword());
        if (loggedInUser != null) {
            String token = jwtTokenProvider.createToken(loggedInUser.getUserId());
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
    
    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody UserDTO user) {
        if (userService.getUserById(user.getUserId()) != null) {
            return ResponseEntity.status(409).body("User ID already exists");
        } else {
            userService.join(user);
            return ResponseEntity.ok("User registered successfully");
        }
    }
   
    
}