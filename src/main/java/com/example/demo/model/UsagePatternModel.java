package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class UsagePatternModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double averageDailyIncrease;

    private LocalDateTime lastUpdated;

    @ManyToOne
    private Bin bin;

    public UsagePatternModel() {
    }

    public Long getId() {
        return id;
    }

    public double getAverageDailyIncrease() {
        return averageDailyIncrease;
    }

    public void setAverageDailyIncrease(double averageDailyIncrease) {
        this.averageDailyIncrease = averageDailyIncrease;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Bin getBin() {
        return bin;
    }

    public void setBin(Bin bin) {
        this.bin = bin;
    }
}
