package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Bin;
import com.example.demo.model.FillLevelRecord;
import com.example.demo.repository.BinRepository;
import com.example.demo.repository.FillLevelRecordRepository;
import com.example.demo.service.FillLevelRecordService;

@Service
public class FillLevelRecordServiceImpl implements FillLevelRecordService {

    private final FillLevelRecordRepository fillLevelRecordRepository;
    private final BinRepository binRepository;

    public FillLevelRecordServiceImpl(
            FillLevelRecordRepository fillLevelRecordRepository,
            BinRepository binRepository) {
        this.fillLevelRecordRepository = fillLevelRecordRepository;
        this.binRepository = binRepository;
    }

    @Override
    public FillLevelRecord createRecord(FillLevelRecord record, Long binId) {
        Bin bin = binRepository.findById(binId).orElse(null);
        if (bin == null) {
            return null;
        }
        record.setBin(bin);
        return fillLevelRecordRepository.save(record);
    }

    @Override
    public FillLevelRecord getRecordById(Long id) {
        return fillLevelRecordRepository.findById(id).orElse(null);
    }

    @Override
    public List<FillLevelRecord> getAllRecords() {
        return fillLevelRecordRepository.findAll();
    }

    @Override
    public void deleteRecord(Long id) {
        fillLevelRecordRepository.deleteById(id);
    }
}
