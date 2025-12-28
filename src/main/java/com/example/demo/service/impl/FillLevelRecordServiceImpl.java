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

    private final FillLevelRecordRepository recordRepository;
    private final BinRepository binRepository;

    public FillLevelRecordServiceImpl(FillLevelRecordRepository recordRepository,
                                      BinRepository binRepository) {
        this.recordRepository = recordRepository;
        this.binRepository = binRepository;
    }

    // CREATE
    @Override
    public FillLevelRecord createRecord(FillLevelRecord record, Long binId) {
        Bin bin = binRepository.findById(binId)
                .orElseThrow(() -> new RuntimeException("Bin not found with id " + binId));

        record.setBin(bin);
        return recordRepository.save(record);
    }

    // READ ALL
    @Override
    public List<FillLevelRecord> getAllRecords() {
        return recordRepository.findAll();
    }

    // READ BY ID
    @Override
    public FillLevelRecord getRecordById(Long id) {
        return recordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found with id " + id));
    }

    // DELETE
    @Override
    public void deleteRecord(Long id) {
        recordRepository.deleteById(id);
    }
}
