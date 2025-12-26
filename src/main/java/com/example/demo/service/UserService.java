package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {

    User saveUser(String name, String email, String username,
                  String password, String role);

    User getUserByEmail(String email);
}
