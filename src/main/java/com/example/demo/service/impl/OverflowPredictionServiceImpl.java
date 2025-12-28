package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.OverflowPrediction;
import com.example.demo.model.Zone;
import com.example.demo.repository.BinRepository;
import com.example.demo.repository.FillLevelRecordRepository;
import com.example.demo.repository.OverflowPredictionRepository;
import com.example.demo.repository.UsagePatternModelRepository;
import com.example.demo.repository.ZoneRepository;
import com.example.demo.service.OverflowPredictionService;

@Service
public class OverflowPredictionServiceImpl implements OverflowPredictionService {

    @Autowired
    private BinRepository binRepository;

    @Autowired
    private FillLevelRecordRepository fillLevelRecordRepository;

    @Autowired
    private UsagePatternModelRepository usagePatternModelRepository;

    @Autowired
    private OverflowPredictionRepository overflowPredictionRepository;

    @Autowired
    private ZoneRepository zoneRepository;

    @Override
    public OverflowPrediction createPrediction(OverflowPrediction prediction) {
        return overflowPredictionRepository.save(prediction);
    }

    @Override
    public OverflowPrediction getPredictionById(Long id) {
        return overflowPredictionRepository.findById(id).orElse(null);
    }

    @Override
    public List<OverflowPrediction> getAllPredictions() {
        return overflowPredictionRepository.findAll();
    }

    @Override
    public List<OverflowPrediction> getLatestPredictionsForZone(Long zoneId) {
        Zone zone = zoneRepository.findById(zoneId).orElse(null);
        if (zone == null) {
            return List.of();
        }
        return overflowPredictionRepository.findByBinZone(zone);
    }
}
