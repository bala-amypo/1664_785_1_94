package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.FillLevelRecord;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;

public interface FillLevelRecordRepository extends JpaRepository<FillLevelRecord, Long> {

    List<FillLevelRecord> findByBinId(Long binId);

    @Query("SELECT f FROM FillLevelRecord f WHERE f.bin.id = :binId ORDER BY f.recordedAt DESC")
    List<FillLevelRecord> findRecentRecords(@Param("binId") Long binId, Pageable pageable);
}
