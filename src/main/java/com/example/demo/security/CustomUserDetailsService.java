package com.example.demo.security;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    public static class DemoUser {
        private Long id;
        private String name;
        private String email;
        private String password;
        private String role;
        // getters/setters
    }

    private final Map<String, DemoUser> users = new HashMap<>();

    public CustomUserDetailsService() {
        DemoUser admin = new DemoUser();
        admin.setId(1L);
        admin.setName("Admin");
        admin.setEmail("admin@city.com");
        admin.setPassword("admin123");
        admin.setRole("ADMIN");
        users.put(admin.getEmail(), admin);
    }

    public DemoUser getByEmail(String email) {
        return users.get(email);
    }

    public DemoUser registerUser(String fullName, String email, String password) {
        if (users.containsKey(email)) {
            throw new RuntimeException("User already exists");
        }
        DemoUser u = new DemoUser();
        u.setId((long) (users.size() + 1));
        u.setName(fullName);
        u.setEmail(email);
        u.setPassword(password);
        u.setRole("USER");
        users.put(email, u);
        return u;
    }

    public boolean exists(String email) {
        return users.containsKey(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DemoUser u = users.get(username);
        if (u == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return User.withUsername(u.getEmail())
                .password(u.getPassword())
                .roles(u.getRole())
                .build();
    }
}
