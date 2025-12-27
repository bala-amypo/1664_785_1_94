package com.example.demo.service.impl;

import java.time.LocalDateTime;
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
    public List<OverflowPrediction> getPredictionsForBin(Long binId) {
        return repository.findByBinId(binId);
    }

    @Override
    public List<OverflowPrediction> getLatestPredictionsByZone(Long zoneId) {
        return repository.findByZoneIdOrderByPredictionTimeDesc(zoneId);
    }

    @Override
    public OverflowPrediction generatePrediction(Long binId) {
        OverflowPrediction prediction = new OverflowPrediction();
        prediction.setPredictionTime(LocalDateTime.now());
      
        return repository.save(prediction);
    }
@Override
public OverflowPrediction getPredictionById(Long id) {
    return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Prediction not found"));
}



}

