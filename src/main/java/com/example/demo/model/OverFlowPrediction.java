package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "overflow_predictions")
public class OverFlowPrediction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "bin_id")
    private Bin bin;

    @Temporal(TemporalType.DATE)
    private Date predictedFullDate;

    private Integer daysUntilFull;

    @ManyToOne
    @JoinColumn(name = "model_used_id")
    private UsagePatternModel modelUsed;

    private Timestamp generatedAt;

    @PrePersist
    protected void onGenerate() {
        generatedAt = new Timestamp(System.currentTimeMillis());
    }

   
}
