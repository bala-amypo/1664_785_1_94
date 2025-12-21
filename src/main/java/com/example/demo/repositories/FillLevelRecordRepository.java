package com.example.demo.repositories;




public interface FillLevelRecordRepository extends JpaRepository<FillRecord, Long> {
    List<FillRecord> findTop10ByBinOrderByRecordedAtDesc(Bin bin);
    List<FillRecord> findTop10ByBinOrderByRecordedAtDesc(Bin bin, LocalDateTime start, LocalDateTime end);
}
