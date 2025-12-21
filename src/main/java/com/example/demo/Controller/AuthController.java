package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication")
public class AuthController {

    private final UserService UserService;

    public AuthController(UserService UserService) {
        this.UserService = UserService;
    }

    @PostMapping("/register")
    public UserService register(
            @RequestParam String fullName,
            @RequestParam String email,
            @RequestParam String password,
    )
    
     {
        return userService.registerUser(fullName, email, password);
    }

    @PostMapping("/login")
    public UserService login(@RequestParam String email) {
        return userService.getByEmail(email);
    }
}
