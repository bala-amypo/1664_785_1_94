package com.example.demo.service;

import java.util.List;

import com.example.demo.model.FillLevelRecord;

public interface FillLevelRecordService {

    // CREATE (used by controller)
    FillLevelRecord createRecord(FillLevelRecord record, Long binId);

    // READ
    List<FillLevelRecord> getAllRecords();

    FillLevelRecord getRecordById(Long id);

    // DELETE
    void deleteRecord(Long id);
}
