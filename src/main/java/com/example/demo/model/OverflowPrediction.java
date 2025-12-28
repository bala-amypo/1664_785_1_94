package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class OverflowPrediction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate predictedFullDate;

    @ManyToOne
    private UsagePatternModel modelUsed;

    public void setPredictedFullDate(LocalDate predictedFullDate) {
        this.predictedFullDate = predictedFullDate;
    }

    public UsagePatternModel getModelUsed() {
        return modelUsed;
    }
}
