package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users") // optional, to avoid conflicts with SQL reserved words
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;  // use fullName consistently

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;
}
