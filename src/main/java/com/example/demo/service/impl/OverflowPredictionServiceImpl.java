package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.OverflowPredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class OverflowPredictionServiceImpl implements OverflowPredictionService {
    
    private final OverflowPredictionRepository overflowPredictionRepository;
    private final BinRepository binRepository;
    private final FillLevelRecordRepository fillLevelRecordRepository;
    private final UsagePatternModelRepository usagePatternModelRepository;
    private final ZoneRepository zoneRepository;
    
    @Autowired
    public OverflowPredictionServiceImpl(
            OverflowPredictionRepository overflowPredictionRepository,
            BinRepository binRepository,
            FillLevelRecordRepository fillLevelRecordRepository,
            UsagePatternModelRepository usagePatternModelRepository,
            ZoneRepository zoneRepository) {
        this.overflowPredictionRepository = overflowPredictionRepository;
        this.binRepository = binRepository;
        this.fillLevelRecordRepository = fillLevelRecordRepository;
        this.usagePatternModelRepository = usagePatternModelRepository;
        this.zoneRepository = zoneRepository;
    }
    
    @Override
    public OverflowPrediction createPrediction(OverflowPrediction prediction) {
        return overflowPredictionRepository.save(prediction);
    }
    
    @Override
    public List<OverflowPrediction> getPredictionsByBinId(Long binId) {
        Bin bin = binRepository.findById(binId)
                .orElseThrow(() -> new RuntimeException("Bin not found"));
        return overflowPredictionRepository.findByBin(bin);
    }
    
    @Override
    public List<OverflowPrediction> getLatestPredictionsForZone(Long zoneId) {
        Zone zone = zoneRepository.findById(zoneId)
                .orElseThrow(() -> new RuntimeException("Zone not found"));
        return overflowPredictionRepository.findByBinZoneOrderByPredictionDateAsc(zone);
    }
    
    @Override
    public OverflowPrediction predictOverflowForBin(Long binId) {
        Bin bin = binRepository.findById(binId)
                .orElseThrow(() -> new RuntimeException("Bin not found"));
        
        // Calculate days until full
        Double fillRate = calculateFillRate(bin);
        Double remainingCapacity = bin.getCapacity() - bin.getCurrentFillLevel();
        Integer daysUntilFull = (int) Math.ceil(remainingCapacity / fillRate);
        
        // Calculate confidence based on available data
        List<FillLevelRecord> records = fillLevelRecordRepository.findTop10ByBinOrderByRecordedAtDesc(bin);
        Double confidence = Math.min(0.95, 0.5 + (records.size() * 0.05));
        
        OverflowPrediction prediction = new OverflowPrediction();
        prediction.setBin(bin);
        prediction.setPredictionDate(LocalDate.now().plusDays(daysUntilFull));
        prediction.setDaysUntilFull(daysUntilFull);
        prediction.setConfidenceScore(confidence);
        
        return overflowPredictionRepository.save(prediction);
    }
    
    @Override
    public Double calculateFillRate(Bin bin) {
        List<FillLevelRecord> records = fillLevelRecordRepository.findTop10ByBinOrderByRecordedAtDesc(bin);
        
        if (records.size() < 2) {
            return bin.getFillRatePerDay() != null ? bin.getFillRatePerDay() : 5.0; // Default fill rate
        }
        
        // Calculate average daily fill rate from records
        double totalFillIncrease = 0;
        long totalDays = 0;
        
        for (int i = 0; i < records.size() - 1; i++) {
            FillLevelRecord current = records.get(i);
            FillLevelRecord previous = records.get(i + 1);
            
            double fillIncrease = current.getFillLevel() - previous.getFillLevel();
            long daysBetween = ChronoUnit.DAYS.between(previous.getRecordedAt(), current.getRecordedAt());
            
            if (daysBetween > 0) {
                totalFillIncrease += fillIncrease;
                totalDays += daysBetween;
            }
        }
        
        return totalDays > 0 ? totalFillIncrease / totalDays : 5.0;
    }
}