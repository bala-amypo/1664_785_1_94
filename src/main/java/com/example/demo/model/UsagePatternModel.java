package com.example.demo.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UsagePatternModel {
    private Long id;
    private String modelName;
    private Double accuracy;
    private LocalDateTime lastUpdated;
    private byte[] modelData;
    private Bin bin;
}