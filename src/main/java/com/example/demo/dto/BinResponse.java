package com.example.demo.dto;

public class BinResponseDTO {

    private Long id;
    private String location;
    private Double capacity;
    private Double currentFillLevel;
    private String zoneName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public Double getCurrentFillLevel() {
        return currentFillLevel;
    }

    public void setCurrentFillLevel(Double currentFillLevel) {
        this.currentFillLevel = currentFillLevel;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }
}
