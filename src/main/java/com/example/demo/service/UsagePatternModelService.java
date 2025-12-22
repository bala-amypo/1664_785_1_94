package com.example.demo.service;

import com.example.demo.model.UsagePatternModel;
import java.util.List;

public interface UsagePatternModelService {
    UsagePatternModel createModel(UsagePatternModel model, Long binId);
    UsagePatternModel getModelForBin(Long binId);
    UsagePatternModel getUsagePatternModelById(Long id);
    List<UsagePatternModel> getAllModels();
    UsagePatternModel updateModel(Long id, UsagePatternModel model);
}
