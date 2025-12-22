package com.example.demo.repository;

import com.example.demo.model.OverFlowPrediction;
import com.example.demo.model.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OverFlowPredictionRepository
        extends JpaRepository<OverFlowPrediction, Long> {

    @Query("""
           SELECT o
           FROM OverflowPrediction o
           WHERE o.bin.zone = :zone
           ORDER BY o.generatedAt DESC
           """)
    List<OverFlowPrediction> findLatestPredictionsForZone(
            @Param("zone") Zone zone
    );
}
