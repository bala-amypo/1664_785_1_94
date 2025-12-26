package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.OverflowPrediction;
import com.example.demo.repository.OverflowPredictionRepository;
import com.example.demo.service.OverflowPredictionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OverflowPredictionServiceImpl implements OverflowPredictionService {

public OverflowPrediction generatePrediction(Long binId);
public OverflowPrediction getPredictionById(Long id);
public java.util.List<OverflowPrediction> getPredictionsForBin(Long binId);
public java.util.List<OverflowPrediction> getLatestPredictionsForZone(Long zoneId);

    private final OverflowPredictionRepository repository;

    public OverflowPredictionServiceImpl(OverflowPredictionRepository repository) {
        this.repository = repository;
    }

    @Override
    public OverflowPrediction generatePrediction(Long binId) {
        OverflowPrediction prediction = new OverflowPrediction();
        return repository.save(prediction);
    }


    @Override
    public OverflowPrediction getPredictionById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prediction not found"));
    }

    @Override
    public List<OverflowPrediction> getPredictionsForBin(Long binId) {
        return repository.findByBinId(binId);
    }

    @Override
public List<OverflowPrediction> getLatestPredictionsByZone(Long zoneId) {
    return repository.findLatestPredictionsByZone(zoneId);
}

}
