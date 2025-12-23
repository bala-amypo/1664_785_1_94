package com.example.demo.repository;

import com.example.demo.model.OverFlowPrediction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OverFlowPredictionRepository
        extends JpaRepository<OverFlowPrediction, Long> {

    Optional<OverFlowPrediction>
    findTopByBin_ZoneIdOrderByPredictedAtDesc(Long zoneId);
}
