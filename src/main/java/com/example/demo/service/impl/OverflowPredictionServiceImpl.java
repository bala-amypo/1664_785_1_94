package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.OverflowPrediction;
import com.example.demo.repository.OverflowPredictionRepository;
import com.example.demo.service.OverflowPredictionService;

@Service
public class OverflowPredictionServiceImpl {

    private final BinRepository binRepository;
    private final FillLevelRecordRepository recordRepository;
    private final UsagePatternModelRepository modelRepository;
    private final OverflowPredictionRepository predictionRepository;
    private final ZoneRepository zoneRepository;

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


    @Autowired
    private OverflowPredictionRepository repository;

    @Override
    public List<OverflowPrediction> getPredictionsForBin(Long binId) {
        // FIXED method name
        return repository.findByBin_Id(binId);
    }

    @Override
    public List<OverflowPrediction> getLatestPredictionsByZone(Long zoneId) {
        // FIXED method name
        return repository.findByZone_IdOrderByPredictionTimeDesc(zoneId);
    }

    @Override
    public OverflowPrediction generatePrediction(Long binId) {
        OverflowPrediction prediction = new OverflowPrediction();
        prediction.setPredictionTime(LocalDateTime.now());

        // NOTE: bin must be set here or DB will fail (FK not null)
        // prediction.setBin(bin);

        return repository.save(prediction);
    }

    @Override
    public OverflowPrediction getPredictionById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prediction not found"));
    }
}
