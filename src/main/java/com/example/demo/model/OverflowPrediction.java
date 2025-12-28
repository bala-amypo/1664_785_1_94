package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class OverflowPrediction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate predictionDate;
    private Double confidenceScore;
    private int daysUntilFull;

    @ManyToOne
    private Bin bin;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getPredictionDate() { return predictionDate; }
    public void setPredictionDate(LocalDate predictionDate) {
        this.predictionDate = predictionDate;
    }

    public Double getConfidenceScore() { return confidenceScore; }
    public void setConfidenceScore(Double confidenceScore) {
        this.confidenceScore = confidenceScore;
    }

    public int getDaysUntilFull() { return daysUntilFull; }
    public void setDaysUntilFull(int daysUntilFull) {
        this.daysUntilFull = daysUntilFull;
    }

    public Bin getBin() { return bin; }
    public void setBin(Bin bin) { this.bin = bin; }
}
