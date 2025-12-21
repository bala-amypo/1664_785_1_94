package com.example.demo.service;



public interface OverFlowPredictionService {

    OverFlowPrediction generatePrediction(Long binId);

    OverflowPrediction getPredictionById(Long id);

    List<OverflowPrediction> getPredictionsForBin(Long binId);

    List<OverflowPrediction> getLatestPredictionsForZone(Long zoneId);
}
