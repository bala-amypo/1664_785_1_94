package com.example.demo.security;

public class CustomUserDetailsService {
    
    public String loadUserByUsername(String username) {
        // Simple implementation for testing
        return "User: " + username;
    }
}