package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Bin;
import com.example.demo.model.FillLevelRecord;
import com.example.demo.model.OverFlowPrediction;
import com.example.demo.repository.BinRepository;
import com.example.demo.repository.FillLevelRecordRepository;
import com.example.demo.repository.OverFlowPredictionRepository;
import com.example.demo.service.OverFlowPredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service  
public class OverFlowPredictionServiceImpl implements OverFlowPredictionService {

    @Autowired
    private OverFlowPredictionRepository predictionRepository;

    @Autowired
    private BinRepository binRepository;

    @Autowired
    private FillLevelRecordRepository recordRepository;

    @Override
    public OverFlowPrediction generatePrediction(Long binId) {

        Bin bin = binRepository.findById(binId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Bin not found with id: " + binId));

        
        FillLevelRecord latestRecord =
                recordRepository.findRecentRecords(binId, 1)
                        .stream()
                        .findFirst()
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "No fill-level data found for bin id: " + binId));

       
        boolean willOverflow = latestRecord.getFillPercentage() >= 80;

        OverFlowPrediction prediction = new OverFlowPrediction();
        prediction.setBin(bin);
        prediction.setPredictedOverflow(willOverflow);
        prediction.setPredictedAt(LocalDateTime.now());

        return predictionRepository.save(prediction);
    }

    @Override
    public OverFlowPrediction getPredictionById(Long id) {
        return predictionRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Prediction not found with id: " + id));
    }

    @Override
    public List<OverFlowPrediction> getPredictionsForBin(Long binId) {
        return predictionRepository.findByBinId(binId);
    }

    @Override
    public List<OverFlowPrediction> getLatestPredictionsForZone(Long zoneId) {
        return predictionRepository.findLatestPredictionsForZone(zoneId);
    }
}
