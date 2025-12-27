package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class OverflowPrediction {

    private int daysUntilFull;
    private LocalDate predictedFullDate;
    private String modelUsed;

    public int getDaysUntilFull() {
        return daysUntilFull;
    }

    public void setDaysUntilFull(int daysUntilFull) {
        this.daysUntilFull = daysUntilFull;
    }

    public LocalDate getPredictedFullDate() {
        return predictedFullDate;
    }

    public void setPredictedFullDate(LocalDate predictedFullDate) {
        this.predictedFullDate = predictedFullDate;
    }

    public String getModelUsed() {
        return modelUsed;
    }

    public void setModelUsed(String modelUsed) {
        this.modelUsed = modelUsed;
    }
}

