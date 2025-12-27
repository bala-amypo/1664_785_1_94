package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "overflow_predictions")
public class OverflowPrediction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDate predictionDate;
    private Double confidenceScore;
    private Integer daysUntilFull;
    
    @ManyToOne
    @JoinColumn(name = "bin_id")
    private Bin bin;
    
    // Constructors
    public OverflowPrediction() {}
    
    public OverflowPrediction(LocalDate predictionDate, Double confidenceScore, Integer daysUntilFull, Bin bin) {
        this.predictionDate = predictionDate;
        this.confidenceScore = confidenceScore;
        this.daysUntilFull = daysUntilFull;
        this.bin = bin;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public LocalDate getPredictionDate() { return predictionDate; }
    public void setPredictionDate(LocalDate predictionDate) { this.predictionDate = predictionDate; }
    
    public Double getConfidenceScore() { return confidenceScore; }
    public void setConfidenceScore(Double confidenceScore) { this.confidenceScore = confidenceScore; }
    
    public Integer getDaysUntilFull() { return daysUntilFull; }
    public void setDaysUntilFull(Integer daysUntilFull) { this.daysUntilFull = daysUntilFull; }
    
    public Bin getBin() { return bin; }
    public void setBin(Bin bin) { this.bin = bin; }
}