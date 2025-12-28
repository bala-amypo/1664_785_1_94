package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.FillLevelRecordService;

public class FillLevelRecordServiceImpl
        implements FillLevelRecordService {

    private final FillLevelRecordRepository fillLevelRecordRepository;
    private final BinRepository binRepository;

    // ⚠ Constructor EXACTLY matches test
    public FillLevelRecordServiceImpl(
            FillLevelRecordRepository fillLevelRecordRepository,
            BinRepository binRepository) {
        this.fillLevelRecordRepository = fillLevelRecordRepository;
        this.binRepository = binRepository;
    }

    @Override
    public FillLevelRecord createRecord(
            FillLevelRecord record, Long binId) {

        binRepository.findById(binId)
                .ifPresent(record::setBin);

        return fillLevelRecordRepository.save(record);
    }
}
