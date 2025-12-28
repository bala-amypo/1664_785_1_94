package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.FillLevelRecord;
import com.example.demo.repository.FillLevelRecordRepository;
import com.example.demo.service.FillLevelRecordService;

@Service
public class FillLevelRecordServiceImpl implements FillLevelRecordService {

    @Autowired
    private FillLevelRecordRepository recordRepository;

    // CREATE
    @Override
    public FillLevelRecord createRecord(FillLevelRecord record) {
        return recordRepository.save(record);
    }

    @Override
    public FillLevelRecord createRecord(FillLevelRecord record, Long binId) {
        // binId already mapped in record if required
        return recordRepository.save(record);
    }

    // READ
    @Override
    public List<FillLevelRecord> getAllRecords() {
        return recordRepository.findAll();
    }

    @Override
    public FillLevelRecord getRecordById(Long id) {
        return recordRepository.findById(id).orElse(null);
    }

    @Override
    public List<FillLevelRecord> getRecentRecords(long binId, int limit) {
        return recordRepository.findTopNByBinIdOrderByRecordedAtDesc(binId, limit);
    }

    // DELETE
    @Override
    public void deleteRecord(Long id) {
        recordRepository.deleteById(id);
    }
}
