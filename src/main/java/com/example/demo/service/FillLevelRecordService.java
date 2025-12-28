package com.example.demo.service;

import java.util.List;

import com.example.demo.model.FillLevelRecord;

public interface FillLevelRecordService {

    // CREATE
    FillLevelRecord createRecord(FillLevelRecord record);
    FillLevelRecord createRecord(FillLevelRecord record, Long binId);

    // READ
    List<FillLevelRecord> getAllRecords();
    FillLevelRecord getRecordById(Long id);
    List<FillLevelRecord> getRecentRecords(long binId, int limit);

    // DELETE
    void deleteRecord(Long id);
}
