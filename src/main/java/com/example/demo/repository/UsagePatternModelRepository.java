package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.UsagePatternModel;
import com.example.demo.model.Bin;
import java.util.Optional;

public interface UsagePatternModelRepository  extends JpaRepository<UsagePatternModel,Long>{
    UsagePatternModel findTopByBinIdOrderByLastUpdatedDesc(Long binId);

}
