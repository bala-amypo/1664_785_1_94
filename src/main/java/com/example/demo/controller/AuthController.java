package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

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
            @RequestParam String password) {
        return userService.registerUser(fullName, email, password);
    }

    @PostMapping("/login")
    public String login() {
        return "JWT_TOKEN_PLACEHOLDER";
    }
}
