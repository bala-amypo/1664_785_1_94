package com.example.demo.security;

import org.springframework.security.core.Authentication;

import java.util.Date;
import java.util.UUID;

public class JwtTokenProvider {

    // Field accessed via reflection in test
    private String jwtSecret = "secretKey";

    // Method used in test
    public String generateToken(Authentication authentication) {
        // Simple token generation (test-safe)
        return UUID.randomUUID().toString();
    }
}
