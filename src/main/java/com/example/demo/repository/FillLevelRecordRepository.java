package com.example.demo.repository;

import com.example.demo.model.Bin;
import com.example.demo.model.FillLevelRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FillLevelRecordRepository extends JpaRepository<FillLevelRecord, Long> {
    List<FillLevelRecord> findByBin(Bin bin);
    List<FillLevelRecord> findTop10ByBinOrderByRecordedAtDesc(Bin bin);
}