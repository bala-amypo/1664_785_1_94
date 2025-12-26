package com.example.demo.repository;

import com.example.demo.model.OverflowPrediction;
import com.example.demo.model.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

@Repository
public interface OverflowPredictionRepository extends JpaRepository<OverflowPrediction,Long>{
    OverflowPrediction save(OverflowPrediction prediction);
   @Query("SELECT p FROM OverflowPrediction p WHERE p.bin.zone = :zone")
List<OverflowPrediction> findLatestPredictionsForZone(@Param("zone") Zone zone);


    List<OverflowPrediction> findByBinId(Long binId);

}

