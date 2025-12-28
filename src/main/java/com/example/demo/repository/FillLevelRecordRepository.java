package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Bin;
import com.example.demo.model.FillLevelRecord;

public interface FillLevelRecordRepository
        extends JpaRepository<FillLevelRecord, Long> {

    // ✅ REQUIRED by TestNG
    List<FillLevelRecord> findByBinOrderByRecordedAtDesc(Bin bin);
}
