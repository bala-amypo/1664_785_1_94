package com.example.demo.repositories;



public interface OverFlowPredictionRepository extends JpaRepository<OverflowPrediction, Long> {
    List<OverflowPrediction> findByZone(Zone zone);
}
