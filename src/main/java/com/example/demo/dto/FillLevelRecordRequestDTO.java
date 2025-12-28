package com.example.demo.dto;

import java.time.LocalDateTime;

public class FillLevelRecordRequestDTO {

    private Double fillLevel;
    private LocalDateTime recordedAt;
    private Long binId;

    public Double getFillLevel() {
        return fillLevel;
    }

    public void setFillLevel(Double fillLevel) {
        this.fillLevel = fillLevel;
    }

    public LocalDateTime getRecordedAt() {
        return recordedAt;
    }

    public void setRecordedAt(LocalDateTime recordedAt) {
        this.recordedAt = recordedAt;
    }

    public Long getBinId() {
        return binId;
    }

    public void setBinId(Long binId) {
        this.binId = binId;
    }
}
