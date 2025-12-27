package com.example.demo.security;

import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService {

    public DemoUser getByEmail(String email) {
        DemoUser user = new DemoUser();
        user.setEmail(email);
        return user;
    }

    public DemoUser registerUser(String name, String email, String password) {
        DemoUser user = new DemoUser();
        user.setEmail(email);
        user.setPassword(password);
        return user;
    }
}
