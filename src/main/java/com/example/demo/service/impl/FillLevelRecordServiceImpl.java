package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.FillLevelRecord;
import com.example.demo.repository.FillLevelRecordRepository;

@Service
public class FillLevelRecordServiceImpl {

    @Autowired
    private FillLevelRecordRepository recordRepository;

    public FillLevelRecord createRecord(FillLevelRecord record, Long binId) {
        return recordRepository.save(record);
    }

    public FillLevelRecord createRecord(FillLevelRecord record) {
        return recordRepository.save(record);
    }

    public List<FillLevelRecord> getRecentRecords(long binId, int limit) {
        return recordRepository.findTopNByBinIdOrderByRecordedAtDesc(binId, limit);
    }
}
