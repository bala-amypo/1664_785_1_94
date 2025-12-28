package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.UsagePatternModel;

public interface UsagePatternModelService {

    UsagePatternModel createModel(UsagePatternModel model, Long binId);

    UsagePatternModel getModelById(Long id);

    List<UsagePatternModel> getAllModels();

    Optional<UsagePatternModel> getLatestModelForBin(Long binId);

    void deleteModel(Long id);
}
