package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.OverflowPredictionService;

import java.util.List;

public class OverflowPredictionServiceImpl
        implements OverflowPredictionService {

    // ⚠ Fields injected via reflection in test
    BinRepository binRepository;
    FillLevelRecordRepository fillLevelRecordRepository;
    UsagePatternModelRepository usagePatternModelRepository;
    OverflowPredictionRepository overflowPredictionRepository;
    ZoneRepository zoneRepository;

    // ⚠ NO-ARG constructor REQUIRED by test
    public OverflowPredictionServiceImpl() {}

    @Override
    public OverflowPrediction createPrediction(
            OverflowPrediction prediction) {
        return overflowPredictionRepository.save(prediction);
    }

    @Override
    public List<OverflowPrediction>
    getLatestPredictionsForZone(Long zoneId) {

        Zone zone = zoneRepository
                .findById(zoneId)
                .orElseThrow();

        return overflowPredictionRepository.findByBinZone(zone);
    }
}
