package com.example.demo.service;

import com.example.demo.model.UsagePatternModel;

import java.util.Optional;

public interface UsagePatternModelService {
    UsagePatternModel createModel(UsagePatternModel model);
    Optional<UsagePatternModel> getLatestModelForBin(Long binId);
}