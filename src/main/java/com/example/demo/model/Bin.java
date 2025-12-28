package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Bin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;
    private Double capacity;
    private Double currentFillLevel;

    @ManyToOne
    private Zone zone;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Double getCapacity() { return capacity; }
    public void setCapacity(Double capacity) { this.capacity = capacity; }

    public Double getCurrentFillLevel() { return currentFillLevel; }
    public void setCurrentFillLevel(Double currentFillLevel) {
        this.currentFillLevel = currentFillLevel;
    }

    public Zone getZone() { return zone; }
    public void setZone(Zone zone) { this.zone = zone; }
}
