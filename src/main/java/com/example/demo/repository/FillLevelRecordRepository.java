package com.example.demo.repository;

import com.example.demo.model.FillLevelRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FillLevelRecordRepository
        extends JpaRepository<FillLevelRecord, Long> {

    @Query("""
        SELECT r FROM FillLevelRecord r
        WHERE r.bin.id = :binId
        ORDER BY r.recordedAt DESC
    """)
    List<FillLevelRecord> findTopByBinIdOrderByRecordedAtDesc(
            @Param("binId") Long binId,
            org.springframework.data.domain.Pageable pageable
    );

    default List<FillLevelRecord> findTopByBinIdOrderByRecordedAtDesc(Long binId, int limit) {
        return findTopByBinIdOrderByRecordedAtDesc(
                binId,
                org.springframework.data.domain.PageRequest.of(0, limit)
        );
    }
}
