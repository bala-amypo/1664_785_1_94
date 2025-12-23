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
import java.util.Optional;

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
        // Find the bin by its ID
        Bin bin = binRepository.findById(binId)
                .orElseThrow(() -> new ResourceNotFoundException("Bin not found with id " + binId));

        // Fetch the 5 most recent fill level records for the bin
        Pageable pageable = PageRequest.of(0, 5);
        List<FillLevelRecord> recentRecords = recordRepository.findRecentRecords(binId, pageable);

        // Check if any record has a fill percentage greater than or equal to 90%
        boolean willOverflow = recentRecords.stream()
                .anyMatch(r -> r.getFillPercentage() >= 90);

        // Create and save the overflow prediction
        OverFlowPrediction prediction = new OverFlowPrediction();
        prediction.setBin(bin);
        prediction.setPredictedOverflow(willOverflow);
        prediction.setPredictedAt(LocalDateTime.now());

        return predictionRepository.save(prediction);
    }

    @Override
    public OverFlowPrediction getPredictionById(Long id) {
        // Fetch prediction by ID
        return predictionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OverFlowPrediction not found with id " + id));
    }

    @Override
    public List<OverFlowPrediction> getPredictionsForBin(Long binId) {
        // Fetch all predictions for the given bin
        return predictionRepository.findByBinId(binId);
    }

    @Override
    public List<OverFlowPrediction> getLatestPredictionsForZone(Long zoneId) {
        // Fetch the latest prediction for the given zone
        Optional<OverFlowPrediction> prediction = predictionRepository.findTop1ByBin_Zone_IdOrderByPredictedAtDesc(zoneId);

        // Return a list containing the prediction if present, otherwise return an empty list
        return prediction.map(List::of).orElseGet(List::of);
    }
}
