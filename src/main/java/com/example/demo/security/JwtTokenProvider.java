package com.example.demo.security;

import org.springframework.security.core.Authentication;
import java.util.UUID;

public class JwtTokenProvider {

    private String jwtSecret = "secret";

    public String generateToken(Authentication auth) {
        return UUID.randomUUID().toString();
    }
}
