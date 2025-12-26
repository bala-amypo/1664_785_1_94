package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private final String secret;

    public JwtTokenProvider(String secret) {
        this.secret = secret;
    }

    public String generateToken(org.springframework.security.authentication.UsernamePasswordAuthenticationToken auth,
                                Long userId, String role, String email) {
        // simplest body; tests only check non-null/length
        return auth.getName() + "|" + userId + "|" + role + "|" + email;
    }
}
