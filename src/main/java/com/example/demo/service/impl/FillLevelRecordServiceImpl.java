package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Bin;
import com.example.demo.model.FillLevelRecord;
import com.example.demo.repository.BinRepository;
import com.example.demo.repository.FillLevelRecordRepository;
import com.example.demo.service.FillLevelRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FillLevelRecordServiceImpl implements FillLevelRecordService {

    @Autowired
    private FillLevelRecordRepository recordRepository;

    @Autowired
    private BinRepository binRepository;

    @Override
    public FillLevelRecord createRecord(FillLevelRecord record, Long binId) {
        Bin bin = binRepository.findById(binId)
                .orElseThrow(() -> new ResourceNotFoundException("Bin not found with id " + binId));
        record.setBin(bin);
        record.setRecordedAt(LocalDateTime.now());
        return recordRepository.save(record);
    }

    @Override
    public List<FillLevelRecord> getRecentRecords(Long binId, int count) {
        Pageable pageable = PageRequest.of(0, count);
        return recordRepository.findRecentRecords(binId, pageable);
    }

    @Override
    public List<FillLevelRecord> getRecordsForBin(Long binId) {
        return recordRepository.findByBinId(binId);
    }

    @Override
    public FillLevelRecord getRecordById(Long id) {
        return recordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FillLevelRecord not found with id " + id));
    }
}
