package com.example.demo.service;

import com.example.demo.model.FillLevelRecord;

public interface FillLevelRecordService {
    FillLevelRecord createRecord(FillLevelRecord record, Long binId);
}
