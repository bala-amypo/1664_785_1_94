package com.example.demo.service;

import com.example.demo.model.UsagePatternModel;
import java.util.Optional;

public interface UsagePatternModelService {
    UsagePatternModel createModel(UsagePatternModel model, Long binId);
    Optional<UsagePatternModel> getLatestModelForBin(Long binId);
}
