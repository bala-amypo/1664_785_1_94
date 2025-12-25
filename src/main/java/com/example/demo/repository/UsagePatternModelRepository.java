package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.UsagePatternModel;

public interface UsagePatternModelRepository {
    Optional<UsagePatternModel> findById(Long id);
    Optional<UsagePatternModel> findTop1ByBinOrderByLastUpdatedDesc(Bin bin);
    UsagePatternModel save(UsagePatternModel model);
}
