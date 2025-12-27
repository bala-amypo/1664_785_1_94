package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class FillLevelRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int fillPercentage;

    private LocalDateTime recordedAt;

    @ManyToOne
    private Bin bin;

    public FillLevelRecord() {
    }

    public Long getId() {
        return id;
    }

    public int getFillPercentage() {
        return fillPercentage;
    }

    public void setFillPercentage(int fillPercentage) {
        this.fillPercentage = fillPercentage;
    }

    public LocalDateTime getRecordedAt() {
        return recordedAt;
    }

    public void setRecordedAt(LocalDateTime recordedAt) {
        this.recordedAt = recordedAt;
    }

    public Bin getBin() {
        return bin;
    }

    public void setBin(Bin bin) {
        this.bin = bin;
    }
}
