package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public UsagePatternModel createModel(UsagePatternModel model, Long binId) {
    Bin bin = binRepository.findById(binId)
            .orElseThrow(() -> new RuntimeException("Bin not found"));
    model.setBin(bin);
    model.setLastUpdated(LocalDateTime.now());
    return modelRepository.save(model);



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double avgDailyIncreaseWeekday;

    private Double avgDailyIncreaseWeekend;

    private LocalDateTime lastUpdated;

    @ManyToOne
    private Bin bin;

    public UsagePatternModel() {
    }

    public UsagePatternModel(Long id,
                             Double avgDailyIncreaseWeekday,
                             Double avgDailyIncreaseWeekend,
                             LocalDateTime lastUpdated,
                             Bin bin) {
        this.id = id;
        this.avgDailyIncreaseWeekday = avgDailyIncreaseWeekday;
        this.avgDailyIncreaseWeekend = avgDailyIncreaseWeekend;
        this.lastUpdated = lastUpdated;
        this.bin = bin;
    }

    public Long getId() {
        return id;
    }

    public Double getAvgDailyIncreaseWeekday() {
        return avgDailyIncreaseWeekday;
    }

    public void setAvgDailyIncreaseWeekday(Double avgDailyIncreaseWeekday) {
        this.avgDailyIncreaseWeekday = avgDailyIncreaseWeekday;
    }

    public Double getAvgDailyIncreaseWeekend() {
        return avgDailyIncreaseWeekend;
    }

    public void setAvgDailyIncreaseWeekend(Double avgDailyIncreaseWeekend) {
        this.avgDailyIncreaseWeekend = avgDailyIncreaseWeekend;
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