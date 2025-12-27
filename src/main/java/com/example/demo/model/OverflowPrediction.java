package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "overflow_prediction")
public class OverflowPrediction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many predictions belong to one bin
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bin_id", nullable = false)
    private Bin bin;

    // Many predictions belong to one zone
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zone_id", nullable = false)
    private Zone zone;

    @Column(name = "prediction_time", nullable = false)
    private LocalDateTime predictionTime;

    @Column(name = "overflow_probability")
    private Double overflowProbability;

    // ----- Constructors -----

    public OverflowPrediction() {
    }

    public OverflowPrediction(Bin bin, Zone zone, LocalDateTime predictionTime, Double overflowProbability) {
        this.bin = bin;
        this.zone = zone;
        this.predictionTime = predictionTime;
        this.overflowProbability = overflowProbability;
    }

    // ----- Getters & Setters -----

    public Long getId() {
        return id;
    }

    public Bin getBin() {
        return bin;
    }

    public void setBin(Bin bin) {
        this.bin = bin;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public LocalDateTime getPredictionTime() {
        return predictionTime;
    }

    public void setPredictionTime(LocalDateTime predictionTime) {
        this.predictionTime = predictionTime;
    }

    public Double getOverflowProbability() {
        return overflowProbability;
    }

    public void setOverflowProbability(Double overflowProbability) {
        this.overflowProbability = overflowProbability;
    }
}
