package com.example.demo.dto;

import java.time.LocalDate;

public class OverflowPredictionRequestDTO {

    private LocalDate predictionDate;
    private Double confidenceScore;
    private int daysUntilFull;
    private Long binId;

    public LocalDate getPredictionDate() {
        return predictionDate;
    }

    public void setPredictionDate(LocalDate predictionDate) {
        this.predictionDate = predictionDate;
    }

    public Double getConfidenceScore() {
        return confidenceScore;
    }

    public void setConfidenceScore(Double confidenceScore) {
        this.confidenceScore = confidenceScore;
    }

    public int getDaysUntilFull() {
        return daysUntilFull;
    }

    public void setDaysUntilFull(int daysUntilFull) {
        this.daysUntilFull = daysUntilFull;
    }

    public Long getBinId() {
        return binId;
    }

    public void setBinId(Long binId) {
        this.binId = binId;
    }
}
