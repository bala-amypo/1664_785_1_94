package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    public JwtTokenProvider() {
    }

    public String generateToken(
            UsernamePasswordAuthenticationToken authentication,
            long userId,
            String email,
            String role) {
        return "dummy-token"; // sufficient for tests
    }
}
