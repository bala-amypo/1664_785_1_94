// package com.example.demo.model;

// import jakarta.persistence.*;

// @Entity
// public class Bin {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String name;
//     private int capacity;
//     private boolean active = true;

//     public Bin() {}

//     public Long getId() { return id; }
//     public String getName() { return name; }
//     public void setName(String name) { this.name = name; }
//     public int getCapacity() { return capacity; }
//     public void setCapacity(int capacity) { this.capacity = capacity; }
//     public boolean isActive() { return active; }
//     public void setActive(boolean active) { this.active = active; }
// }
package com.example.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bins")
public class Bin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String location;
    private Double capacity;
    private Double currentFillLevel;
    private Double fillRatePerDay;
    
    @ManyToOne
    @JoinColumn(name = "zone_id")
    private Zone zone;
    
    @OneToMany(mappedBy = "bin", cascade = CascadeType.ALL)
    private List<FillLevelRecord> fillLevelRecords = new ArrayList<>();
    
    @OneToMany(mappedBy = "bin", cascade = CascadeType.ALL)
    private List<UsagePatternModel> usagePatternModels = new ArrayList<>();
    
    @OneToMany(mappedBy = "bin", cascade = CascadeType.ALL)
    private List<OverflowPrediction> overflowPredictions = new ArrayList<>();
    
    // Constructors
    public Bin() {}
    
    public Bin(String location, Double capacity, Double currentFillLevel) {
        this.location = location;
        this.capacity = capacity;
        this.currentFillLevel = currentFillLevel;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    
    public Double getCapacity() { return capacity; }
    public void setCapacity(Double capacity) { this.capacity = capacity; }
    
    public Double getCurrentFillLevel() { return currentFillLevel; }
    public void setCurrentFillLevel(Double currentFillLevel) { this.currentFillLevel = currentFillLevel; }
    
    public Double getFillRatePerDay() { return fillRatePerDay; }
    public void setFillRatePerDay(Double fillRatePerDay) { this.fillRatePerDay = fillRatePerDay; }
    
    public Zone getZone() { return zone; }
    public void setZone(Zone zone) { this.zone = zone; }
    
    public List<FillLevelRecord> getFillLevelRecords() { return fillLevelRecords; }
    public void setFillLevelRecords(List<FillLevelRecord> fillLevelRecords) { this.fillLevelRecords = fillLevelRecords; }
    
    public List<UsagePatternModel> getUsagePatternModels() { return usagePatternModels; }
    public void setUsagePatternModels(List<UsagePatternModel> usagePatternModels) { this.usagePatternModels = usagePatternModels; }
    
    public List<OverflowPrediction> getOverflowPredictions() { return overflowPredictions; }
    public void setOverflowPredictions(List<OverflowPrediction> overflowPredictions) { this.overflowPredictions = overflowPredictions; }
}