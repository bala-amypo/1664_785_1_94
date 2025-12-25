package com.example.demo.service;

import com.example.demo.model.UsagePatternModel;
import java.util.List;

public interface UsagePatternModelService {

    UsagePatternModel createModel(UsagePatternModel model, Long binId);

    UsagePatternModel updateModel(Long id, UsagePatternModel model);

    UsagePatternModel getUsagePatternModelById(Long id);

    UsagePatternModel getModelForBin(Long binId);

    List<UsagePatternModel> getAllModels();
}
