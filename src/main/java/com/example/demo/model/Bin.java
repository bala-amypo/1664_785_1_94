package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Bin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identifier;
    private double capacityLiters;
    private double latitude;
    private double longitude;
    private boolean active = true;

    private String locationDescription;

    @ManyToOne
    private Zone zone;

    // ===== getters & setters =====

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getIdentifier() { return identifier; }
    public void setIdentifier(String identifier) { this.identifier = identifier; }

    public double getCapacityLiters() { return capacityLiters; }
    public void setCapacityLiters(double capacityLiters) { this.capacityLiters = capacityLiters; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public boolean getActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public String getLocationDescription() { return locationDescription; }
    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public Zone getZone() { return zone; }
    public void setZone(Zone zone) { this.zone = zone; }
}
