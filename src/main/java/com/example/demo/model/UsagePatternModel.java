package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "usage_pattern_models")
public class UsagePatternModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "bin_id")
    private Bin bin;

    @Column(nullable = false)
    private Double avgDailyIncreaseWeekday;

    @Column(nullable = false)
    private Double avgDailyIncreaseWeekend;

    private Timestamp lastUpdated;

    @PrePersist
    @PreUpdate
    protected void updateTimestamp() {
        lastUpdated = new Timestamp(System.currentTimeMillis());
    }

    
}
