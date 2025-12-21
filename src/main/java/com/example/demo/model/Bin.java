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
    @Column(unique=true)
    private String identifier;
    private Double latitude;
}