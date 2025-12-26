package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.FillLevelRecord;
import com.example.demo.model.Bin;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;
import java.util.Optional;
import java.time.LocalDateTime;


public interface FillLevelRecordRepository extends JpaRepository<FillLevelRecord, Long> {

    List<FillLevelRecord> findByBinId(Long binId);

    Optional<FillLevelRecord> findById(Long id);
    List<FillLevelRecord> findByBinOrderByRecordedAtDesc(Bin bin);
Optional<FillLevelRecord> findTop1ByBinOrderByRecordedAtDesc(Bin bin);
List<FillLevelRecord> findByBinAndRecordedAtBetween(
        Bin bin, java.time.LocalDateTime start, java.time.LocalDateTime end);
    );
    FillLevelRecord save(FillLevelRecord record);
    @Query("SELECT f FROM FillLevelRecord f WHERE f.bin.id = :binId ORDER BY f.recordedAt DESC")
    List<FillLevelRecord> findRecentRecords(@Param("binId") Long binId, Pageable pageable);
}
