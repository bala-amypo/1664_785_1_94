package com.example.demo.model;

import lombok.Data;
import java.time.LocalDate;

@Data
public class OverflowPrediction {
    private Long id;
    private LocalDate predictionDate;
    private Double confidenceScore;
    private Integer daysUntilFull;
    private Bin bin;
}