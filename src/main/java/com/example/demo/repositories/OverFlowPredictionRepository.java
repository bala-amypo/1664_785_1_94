package com.example.demo.repository;

import com.example.demo.model.OverflowPrediction;
import com.example.demo.model.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OverFlowPredictionRepository
        extends JpaRepository<OverflowPrediction, Long> {

    @Query("""
           SELECT o
           FROM OverflowPrediction o
           WHERE o.bin.zone = :zone
           ORDER BY o.generatedAt DESC
           """)
    List<OverflowPrediction> findLatestPredictionsForZone(
            @Param("zone") Zone zone
    );
}
