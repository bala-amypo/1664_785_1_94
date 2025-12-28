package com.example.demo.service;

import java.util.List;
import com.example.demo.model.OverflowPrediction;

public interface OverflowPredictionService {

    OverflowPrediction createPrediction(OverflowPrediction prediction);

    OverflowPrediction getPredictionById(Long id);

    List<OverflowPrediction> getAllPredictions();

    List<OverflowPrediction> getLatestPredictionsForZone(Long zoneId);
}
