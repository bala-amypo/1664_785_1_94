package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usage_pattern_models")
public class UsagePatternModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String modelName;
    private Double accuracy;
    private LocalDateTime lastUpdated;
    
    @Lob
    private byte[] modelData;
    
    @ManyToOne
    @JoinColumn(name = "bin_id")
    private Bin bin;
    
    // Constructors
    public UsagePatternModel() {}
    
    public UsagePatternModel(String modelName, Double accuracy, LocalDateTime lastUpdated, Bin bin) {
        this.modelName = modelName;
        this.accuracy = accuracy;
        this.lastUpdated = lastUpdated;
        this.bin = bin;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getModelName() { return modelName; }
    public void setModelName(String modelName) { this.modelName = modelName; }
    
    public Double getAccuracy() { return accuracy; }
    public void setAccuracy(Double accuracy) { this.accuracy = accuracy; }
    
    public LocalDateTime getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(LocalDateTime lastUpdated) { this.lastUpdated = lastUpdated; }
    
    public byte[] getModelData() { return modelData; }
    public void setModelData(byte[] modelData) { this.modelData = modelData; }
    
    public Bin getBin() { return bin; }
    public void setBin(Bin bin) { this.bin = bin; }
}