package com.example.demo.repository;

import com.example.demo.model.OverflowPrediction;
import com.example.demo.model.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OverflowPredictionRepository
        extends JpaRepository<OverflowPrediction, Long> {

    @Query("""
        SELECT p FROM OverflowPrediction p
        WHERE p.bin.zone = :zone
        AND p.id IN (
            SELECT MAX(p2.id)
            FROM OverflowPrediction p2
            GROUP BY p2.bin
        )
    """)
    List<OverflowPrediction> findLatestPredictionsForZone(@Param("zone") Zone zone);
}
