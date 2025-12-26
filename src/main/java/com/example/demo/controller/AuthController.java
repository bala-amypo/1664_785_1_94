package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password) {

        User user = userService.registerUser(name, email, password);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/user")
    public ResponseEntity<User> getUser(@RequestParam String email) {

        User user = userService.getUserByEmail(email);
        return ResponseEntity.ok(user);
    }
}
