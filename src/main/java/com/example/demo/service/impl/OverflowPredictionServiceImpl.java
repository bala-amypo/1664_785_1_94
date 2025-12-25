package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Bin;
import com.example.demo.model.FillLevelRecord;
import com.example.demo.model.OverflowPrediction;
import com.example.demo.repository.BinRepository;
import com.example.demo.repository.FillLevelRecordRepository;
import com.example.demo.repository.OverflowPredictionRepository;
import com.example.demo.service.OverflowPredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OverflowPredictionServiceImpl implements OverflowPredictionService {

    @Autowired
    private OverflowPredictionRepository predictionRepository;

    @Autowired
    private FillLevelRecordRepository recordRepository;

    @Autowired
    private BinRepository binRepository;

    @Override
    public OverflowPrediction generatePrediction(Long binId) {
       
        Bin bin = binRepository.findById(binId)
                .orElseThrow(() -> new ResourceNotFoundException("Bin not found with id " + binId));

        
        Pageable pageable = PageRequest.of(0, 5);
        List<FillLevelRecord> recentRecords = recordRepository.findRecentRecords(binId, pageable);

       
        boolean willOverflow = recentRecords.stream()
                .anyMatch(r -> r.getFillPercentage() >= 90);

        
        OverflowPrediction prediction = new OverflowPrediction();
        prediction.setBin(bin);
        prediction.setPredictedOverflow(willOverflow);
        prediction.setPredictedAt(LocalDateTime.now());

        return predictionRepository.save(prediction);
    }

    @Override
    public OverflowPrediction getPredictionById(Long id) {
        
        return predictionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OverflowPrediction not found with id " + id));
    }

    @Override
    public List<OverflowPrediction> getPredictionsForBin(Long binId) {
        
        return predictionRepository.findByBinId(binId);
    }

    @Override
    public List<OverflowPrediction> getLatestPredictionsForZone(Long zoneId) {
        
        Optional<OverflowPrediction> prediction = predictionRepository.findTop1ByBin_Zone_IdOrderByPredictedAtDesc(zoneId);

       
        return prediction.map(List::of).orElseGet(List::of);
    }
}
