package com.example.demo.service;



public interface FillLevelRecordService {

    FillRecord createRecord(FillRecord record);

    List<FillRecord> getRecordsForBin(Long binId);

    FillRecord getRecordById(Long id);

    List<FillRecord> getRecentRecords(Long binId, int limit);
}
