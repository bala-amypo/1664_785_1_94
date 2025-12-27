package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class UsagePatternModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long binId;
    private double averageDailyIncrease;
    private LocalDateTime lastUpdated;

    public UsagePatternModel() {}

    public Long getId() { return id; }
    public Long getBinId() { return binId; }
    public void setBinId(Long binId) { this.binId = binId; }
    public double getAverageDailyIncrease() { return averageDailyIncrease; }
    public void setAverageDailyIncrease(double averageDailyIncrease) { this.averageDailyIncrease = averageDailyIncrease; }

    // Required by your service
    public double getAvgDailyIncreaseWeekday() { return averageDailyIncrease; }

    public LocalDateTime getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(LocalDateTime lastUpdated) { this.lastUpdated = lastUpdated; }
}
