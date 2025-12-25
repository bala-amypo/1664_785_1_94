package com.example.demo.repository;

import com.example.demo.model.OverflowPrediction;
import com.example.demo.model.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OverflowPredictionRepository {
    OverflowPrediction save(OverflowPrediction prediction);
    List<OverflowPrediction> findLatestPredictionsForZone(Zone zone);
    List<OverflowPrediction> findByBinId(Long binId);

}

