package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Entity;


@Entity
public class Bin{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String identifier;
}