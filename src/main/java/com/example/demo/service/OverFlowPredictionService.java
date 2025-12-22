package com.example.demo.service;

import com.example.demo.model.OverFlowPrediction;
import java.util.List;

public interface OverFlowPredictionService {
    OverFlowPrediction generatePrediction(Long binId); // matches implementation
    OverFlowPrediction getPredictionById(Long id);
    List<OverFlowPrediction> getPredictionsForBin(Long binId);
    List<OverFlowPrediction> getLatestPredictionsForZone(Long zoneId);
}
