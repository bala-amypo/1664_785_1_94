package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.Tag;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(
            @RequestParam String fullName,
            @RequestParam String email,
            @RequestParam String password
    ) {
        return userService.registerUser(fullName, email, password);
    }

    @PostMapping("/login")
    public User login(@RequestParam String email) {
        return userService.getByEmail(email);
    }
}
