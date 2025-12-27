package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fill_level_records")
public class FillLevelRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Double fillLevel;
    private LocalDateTime recordedAt;
    
    @ManyToOne
    @JoinColumn(name = "bin_id")
    private Bin bin;
    
    // Constructors
    public FillLevelRecord() {}
    
    public FillLevelRecord(Double fillLevel, LocalDateTime recordedAt, Bin bin) {
        this.fillLevel = fillLevel;
        this.recordedAt = recordedAt;
        this.bin = bin;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Double getFillLevel() { return fillLevel; }
    public void setFillLevel(Double fillLevel) { this.fillLevel = fillLevel; }
    
    public LocalDateTime getRecordedAt() { return recordedAt; }
    public void setRecordedAt(LocalDateTime recordedAt) { this.recordedAt = recordedAt; }
    
    public Bin getBin() { return bin; }
    public void setBin(Bin bin) { this.bin = bin; }
}