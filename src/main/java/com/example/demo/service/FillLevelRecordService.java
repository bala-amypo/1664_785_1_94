package com.example.demo.service;

import com.example.demo.model.FillLevelRecord;
import java.util.List;

public interface FillLevelRecordService {
    FillLevelRecord createRecord(FillLevelRecord record, Long binId);
    List<FillLevelRecord> getRecentRecords(Long binId, int count);
    List<FillLevelRecord> getRecordsForBin(Long binId);
    FillLevelRecord getRecordById(Long id);
}
