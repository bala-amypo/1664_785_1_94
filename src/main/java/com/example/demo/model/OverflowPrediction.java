package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class OverflowPrediction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int daysUntilFull;

    private LocalDate predictedFullDate;

    private String modelUsed;

    @ManyToOne
    private Bin bin;

    public OverflowPrediction() {
    }

    public Long getId() {
        return id;
    }

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

    public Bin getBin() {
        return bin;
    }

    public void setBin(Bin bin) {
        this.bin = bin;
    }
}
