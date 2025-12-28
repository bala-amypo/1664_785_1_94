package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class FillLevelRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double fillPercentage;

    private LocalDateTime recordedAt;

    @ManyToOne
    private Bin bin;

    // getters & setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getFillPercentage() { return fillPercentage; }
    public void setFillPercentage(double fillPercentage) {
        this.fillPercentage = fillPercentage;
    }

    public LocalDateTime getRecordedAt() { return recordedAt; }
    public void setRecordedAt(LocalDateTime recordedAt) {
        this.recordedAt = recordedAt;
    }

    public Bin getBin() { return bin; }
    public void setBin(Bin bin) { this.bin = bin; }
}
