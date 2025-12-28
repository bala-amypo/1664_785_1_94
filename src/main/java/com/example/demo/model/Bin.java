package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "bins")
public class Bin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String identifier;

    private String locationDescription;
    private Double latitude;
    private Double longitude;

    @ManyToOne
    private Zone zone;

    private Double capacityLiters;
    private Boolean active;

    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Bin() {}

    public Bin(String identifier, String locationDescription, Double latitude,
               Double longitude, Zone zone, Double capacityLiters,
               Boolean active, Timestamp createdAt, Timestamp updatedAt) {
        this.identifier = identifier;
        this.locationDescription = locationDescription;
        this.latitude = latitude;
        this.longitude = longitude;
        this.zone = zone;
        this.capacityLiters = capacityLiters;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // getters and setters
}
