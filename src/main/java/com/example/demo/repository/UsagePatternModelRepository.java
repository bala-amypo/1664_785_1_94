package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.UsagePatternModel;
import com.example.demo.model.Bin;
import java.util.Optional;

public interface UsagePatternModelRepository  extends JpaRepository<UsagePatternModel,Long>{
    Optional<UsagePatternModel> findById(Long id);
    Optional<UsagePatternModel> findTop1ByBinOrderByLastUpdatedDesc(Bin bin);
    UsagePatternModel save(UsagePatternModel model);
}
