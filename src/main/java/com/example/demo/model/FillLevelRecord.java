package com.example.demo.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class FillLevelRecord {
    private Long id;
    private Double fillLevel;
    private LocalDateTime recordedAt;
    private Bin bin;
}