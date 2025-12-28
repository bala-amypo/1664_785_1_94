package com.example.demo.service;

import java.util.List;
import com.example.demo.model.FillLevelRecord;

public interface FillLevelRecordService {

    FillLevelRecord createRecord(FillLevelRecord record, Long binId);

    FillLevelRecord getRecordById(Long id);

    List<FillLevelRecord> getAllRecords();

    void deleteRecord(Long id);
}
