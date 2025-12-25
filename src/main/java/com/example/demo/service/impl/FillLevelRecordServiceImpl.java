package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.FillLevelRecord;
import com.example.demo.repository.FillLevelRecordRepository;
import com.example.demo.service.FillLevelRecordService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FillLevelRecordServiceImpl implements FillLevelRecordService {

    private final FillLevelRecordRepository repository;

    public FillLevelRecordServiceImpl(FillLevelRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public FillLevelRecord createRecord(FillLevelRecord record) {
        if (record.getRecordedDate().isAfter(LocalDate.now())) {
            throw new BadRequestException("Future date not allowed");
        }
        return repository.save(record);
    }

    @Override
    public List<FillLevelRecord> getRecordsForBin(Long binId) {
        return repository.findByBinId(binId);
    }

    @Override
    public FillLevelRecord getRecordById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found"));
    }

    @Override
