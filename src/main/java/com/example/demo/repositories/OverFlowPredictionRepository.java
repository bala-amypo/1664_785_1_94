package com.example.demo.repository;

import com.example.demo.model.OverFlowPrediction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OverFlowPredictionRepository
        extends JpaRepository<OverFlowPrediction, Long> {

    List<OverFlowPrediction> findByBinId(Long binId);

    // List<OverFlowPrediction> 
    // findTop1ByBin_Zone_IdOrderByPredictedAtDesc(Long zoneId);
    Optional<OverFlowPrediction>
findTopByBin_ZoneIdOrderByPredictedAtDesc(Long zoneId);

}
