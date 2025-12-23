package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;

    public User() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {   // ✅ REQUIRED
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) { // ✅ REQUIRED
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) { // ✅ REQUIRED
        this.password = password;
    }
}
