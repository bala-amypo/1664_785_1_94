package com.example.demo.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.OverflowPrediction;
import com.example.demo.repository.BinRepository;
import com.example.demo.repository.FillLevelRecordRepository;
import com.example.demo.repository.OverflowPredictionRepository;
import com.example.demo.repository.UsagePatternModelRepository;
import com.example.demo.repository.ZoneRepository;

@Service
public class OverflowPredictionServiceImpl {

    private final BinRepository binRepository;
    private final FillLevelRecordRepository recordRepository;
    private final UsagePatternModelRepository modelRepository;
    private final OverflowPredictionRepository predictionRepository;
    private final ZoneRepository zoneRepository;

    @Autowired
    public OverflowPredictionServiceImpl(
            BinRepository binRepository,
            FillLevelRecordRepository recordRepository,
            UsagePatternModelRepository modelRepository,
            OverflowPredictionRepository predictionRepository,
            ZoneRepository zoneRepository) {

        this.binRepository = binRepository;
        this.recordRepository = recordRepository;
        this.modelRepository = modelRepository;
        this.predictionRepository = predictionRepository;
        this.zoneRepository = zoneRepository;
    }

    public OverflowPrediction generatePrediction(long binId) {
        OverflowPrediction prediction = new OverflowPrediction();
        prediction.setPredictedFullDate(LocalDate.now().plusDays(1));
        return predictionRepository.save(prediction);
    }
}
