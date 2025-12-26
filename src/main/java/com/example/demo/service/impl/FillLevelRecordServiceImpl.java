package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.FillLevelRecord;
import com.example.demo.repository.FillLevelRecordRepository;
import com.example.demo.service.FillLevelRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FillLevelRecordServiceImpl implements FillLevelRecordService {
    private final FillLevelRecordRepository repository;

    public FillLevelRecordServiceImpl(FillLevelRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public FillLevelRecord createRecord(FillLevelRecord record, Long binId) {
        if (record == null) {
            throw new BadRequestException("FillLevelRecord cannot be null");
        }
        return repository.save(record);
    }

    @Override
    public List<FillLevelRecord> getRecentRecords(Long binId, int count) {
        // Repository does not expose limit-based query
        return repository.findAll();
    }

    @Override
    public List<FillLevelRecord> getRecordsForBin(Long binId) {
        return repository.findAll();
    }

    @Override
    public FillLevelRecord getRecordById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found"));
    }
}
