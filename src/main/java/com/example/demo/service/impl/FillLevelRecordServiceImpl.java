package com.example.demo.service.impl;

import com.example.demo.model.Bin;
import com.example.demo.model.FillLevelRecord;
import com.example.demo.repository.BinRepository;
import com.example.demo.repository.FillLevelRecordRepository;
import com.example.demo.service.FillLevelRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FillLevelRecordServiceImpl implements FillLevelRecordService {
    
    private final FillLevelRecordRepository fillLevelRecordRepository;
    private final BinRepository binRepository;
    
    @Autowired
    public FillLevelRecordServiceImpl(FillLevelRecordRepository fillLevelRecordRepository,
                                      BinRepository binRepository) {
        this.fillLevelRecordRepository = fillLevelRecordRepository;
        this.binRepository = binRepository;
    }
    
    @Override
    public FillLevelRecord createRecord(FillLevelRecord record) {
        return fillLevelRecordRepository.save(record);
    }
    
    @Override
    public List<FillLevelRecord> getRecordsByBinId(Long binId) {
        Bin bin = binRepository.findById(binId)
                .orElseThrow(() -> new RuntimeException("Bin not found"));
        return fillLevelRecordRepository.findByBin(bin);
    }
}