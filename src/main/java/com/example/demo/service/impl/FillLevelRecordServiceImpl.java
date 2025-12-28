package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Bin;
import com.example.demo.model.FillLevelRecord;
import com.example.demo.repository.BinRepository;
import com.example.demo.repository.FillLevelRecordRepository;

@Service
public class FillLevelRecordServiceImpl {

    private final FillLevelRecordRepository recordRepository;
    private final BinRepository binRepository;

    // 🔹 Constructor required by Spring + tests
    public FillLevelRecordServiceImpl(FillLevelRecordRepository recordRepository,
                                      BinRepository binRepository) {
        this.recordRepository = recordRepository;
        this.binRepository = binRepository;
    }

    // ✅ Used by tests
    public FillLevelRecord createRecord(FillLevelRecord record) {
        record.setRecordedAt(LocalDateTime.now());
        return recordRepository.save(record);
    }

    // ✅ Used by tests
    public FillLevelRecord createRecord(FillLevelRecord record, Long binId) {
        Bin bin = binRepository.findById(binId).orElse(null);
        record.setBin(bin);
        record.setRecordedAt(LocalDateTime.now());
        return recordRepository.save(record);
    }

    // ✅ Used by tests
    public List<FillLevelRecord> getRecentRecords(long binId, int limit) {
        Bin bin = binRepository.findById(binId).orElse(null);
        return recordRepository.findByBinOrderByRecordedAtDesc(bin)
                               .stream()
                               .limit(limit)
                               .toList();
    }
}
