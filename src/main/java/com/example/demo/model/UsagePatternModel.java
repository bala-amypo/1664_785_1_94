package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "usage_pattern_models")
public class UsagePatternModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Bin bin;

    private Double avgDailyIncreaseWeekday;
    private Double avgDailyIncreaseWeekend;
    private Timestamp lastUpdated;

    public UsagePatternModel() {}

    public UsagePatternModel(Bin bin, Double avgDailyIncreaseWeekday,
                             Double avgDailyIncreaseWeekend, Timestamp lastUpdated) {
        this.bin = bin;
        this.avgDailyIncreaseWeekday = avgDailyIncreaseWeekday;
        this.avgDailyIncreaseWeekend = avgDailyIncreaseWeekend;
        this.lastUpdated = lastUpdated;
    }

    // getters and setters
}
