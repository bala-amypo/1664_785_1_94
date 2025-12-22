package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {
    User registerUser(String name, String email, String password);
    User getUserByEmail(String email);
    boolean exists(String email); // this was missing in your impl
}
