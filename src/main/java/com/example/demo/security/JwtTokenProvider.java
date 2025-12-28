package com.example.demo.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    public String generateToken(String email) {
        return "token-" + email;
    }

    public String generateToken(
            UsernamePasswordAuthenticationToken authentication,
            long userId,
            String email,
            String role) {

        return generateToken(email);
    }
}
