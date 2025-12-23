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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OverFlowPredictionServiceImpl implements OverFlowPredictionService {

    @Autowired
    private OverFlowPredictionRepository predictionRepository;

    @Autowired
    private FillLevelRecordRepository recordRepository;

    @Autowired
    private BinRepository binRepository;

    @Override
    public OverFlowPrediction generatePrediction(Long binId) {
        Bin bin = binRepository.findById(binId)
                .orElseThrow(() -> new ResourceNotFoundException("Bin not found with id " + binId));

        Pageable pageable = PageRequest.of(0, 5); // choose last 5 records or adjust as needed
        List<FillLevelRecord> recentRecords = recordRepository.findRecentRecords(binId, pageable);

        boolean willOverflow = recentRecords.stream()
                .anyMatch(r -> r.getFillPercentage() >= 90);

        OverFlowPrediction prediction = new OverFlowPrediction();
        prediction.setBin(bin);
        prediction.setPredictedOverflow(willOverflow);
        prediction.setPredictedAt(LocalDateTime.now());

        return predictionRepository.save(prediction);
    }

    @Override
    public OverFlowPrediction getPredictionById(Long id) {
        return predictionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OverFlowPrediction not found with id " + id));
    }

    @Override
    public List<OverFlowPrediction> getPredictionsForBin(Long binId) {
        return predictionRepository.findByBinId(binId);
    }

    @Override
    public List<OverFlowPrediction> getLatestPredictionsForZone(Long zoneId) {
        
        return predictionRepository.findTopByZoneIdOrderByPredictedAtDesc(zoneId);
    }
}
