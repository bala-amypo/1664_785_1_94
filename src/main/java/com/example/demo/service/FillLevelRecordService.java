package com.example.demo.service;

import java.util.List;

import com.example.demo.model.FillLevelRecord;

public interface FillLevelRecordService {

    // CREATE (used by controller & tests)
    FillLevelRecord createRecord(FillLevelRecord record);

    // READ recent records
    List<FillLevelRecord> getRecentRecords(long binId, int limit);
}
