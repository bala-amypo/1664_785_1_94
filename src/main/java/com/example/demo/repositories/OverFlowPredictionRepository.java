package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.OverFlowPrediction;
import java.util.List;

public interface OverFlowPredictionRepository extends JpaRepository<OverFlowPrediction, Long> {

    List<OverFlowPrediction> findByBinId(Long binId);
}
