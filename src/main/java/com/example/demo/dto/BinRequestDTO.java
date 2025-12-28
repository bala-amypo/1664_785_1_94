package com.example.demo.dto;

public class BinRequestDTO {

    private String location;
    private Double capacity;
    private Double currentFillLevel;
    private Long zoneId;

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

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }
}

