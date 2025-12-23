package com.example.demo.repository;

import com.example.demo.model.OverFlowPrediction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OverFlowPredictionRepository
        extends JpaRepository<OverFlowPrediction, Long> {

    List<OverFlowPrediction> findByBinId(Long binId);

    Optional<OverFlowPrediction>
    findTop1ByBin_Zone_IdOrderByPredictedAtDesc(Long zoneId);
}
