package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.OverflowPrediction;
import com.example.demo.repository.OverflowPredictionRepository;
import com.example.demo.service.OverflowPredictionService;

@Service
public class OverflowPredictionServiceImpl
        implements OverflowPredictionService {

    @Autowired
    private OverflowPredictionRepository repository;

    @Override
    public List<OverflowPrediction> getPredictionsByBin(Long binId) {
        return repository.findByBinId(binId);
    }

    @Override
    public List<OverflowPrediction> getLatestPredictionsByZone(Long zoneId) {
        return repository.findByZoneIdOrderByPredictionTimeDesc(zoneId);
    }
}
