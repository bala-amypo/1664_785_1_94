package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class UsagePatternModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double avgDailyIncreaseWeekday;
    private double avgDailyIncreaseWeekend;

    @ManyToOne
    private Bin bin;

    // getters & setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getAvgDailyIncreaseWeekday() {
        return avgDailyIncreaseWeekday;
    }

    public void setAvgDailyIncreaseWeekday(double v) {
        this.avgDailyIncreaseWeekday = v;
    }

    public double getAvgDailyIncreaseWeekend() {
        return avgDailyIncreaseWeekend;
    }

    public void setAvgDailyIncreaseWeekend(double v) {
        this.avgDailyIncreaseWeekend = v;
    }

    public Bin getBin() { return bin; }
    public void setBin(Bin bin) { this.bin = bin; }
}
