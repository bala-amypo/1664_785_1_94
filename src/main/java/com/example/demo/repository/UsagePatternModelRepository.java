package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.UsagePatternModel;

public interface UsagePatternModelRepository extends JpaRepository<UsagePatternModel, Long> {
    UsagePatternModel findByBinId(Long binId);
}
