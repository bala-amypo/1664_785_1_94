package com.example.demo.security;

import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService {

    public static class DemoUser {
        private String email;

        public DemoUser(String email) {
            this.email = email;
        }

        public String getEmail() {
            return email;
        }
    }

    public DemoUser getByEmail(String email) {
        return new DemoUser(email);
    }

    public DemoUser registerUser(String name, String email, String password) {
        return new DemoUser(email);
    }
}
