package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.OverflowPrediction;

public interface OverflowPredictionRepository
        extends JpaRepository<OverflowPrediction, Long> {

    @Query("""
       SELECT p FROM OverflowPrediction p
       WHERE p.bin.zone = :zone
       AND p.createdAt = (
           SELECT MAX(p2.createdAt)
           FROM OverflowPrediction p2
           WHERE p2.bin = p.bin
       )
    """)
    List<OverflowPrediction> findLatestPredictionsForZone(@Param("zone") Zone zone);
public List<OverflowPrediction> getLatestPredictionsForZone(long zoneId) {
    Zone zone = zoneRepository.findById(zoneId)
            .orElseThrow(() -> new RuntimeException("Zone not found"));
    return predictionRepository.findLatestPredictionsForZone(zone);
}

}
