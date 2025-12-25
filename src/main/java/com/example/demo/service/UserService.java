package com.example.demo.service;

import com.example.demo.model.User;
import java.util.Optional;
public interface UserService {
    User registerUser(String name, String email, String password);
    Optional<User> getUserByEmail(String email);
    boolean exists(String email); 
}
