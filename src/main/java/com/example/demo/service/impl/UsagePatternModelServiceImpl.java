package com.example.demo.service.impl;

import com.example.demo.model.UsagePatternModel;
import com.example.demo.repository.UsagePatternModelRepository;
import org.springframework.stereotype.Service;

@Service
public class UsagePatternModelServiceImpl {

    private final UsagePatternModelRepository repository;

    public UsagePatternModelServiceImpl(UsagePatternModelRepository repository) {
        this.repository = repository;
    }

    public UsagePatternModel getLatestModelForBin(Long binId) {
        UsagePatternModel model =
                repository.findTopByBinIdOrderByLastUpdatedDesc(binId);

        if (model == null) {
            throw new RuntimeException("No usage model found for bin");
        }

        return model;
    }

    public double getWeekdayIncrease(Long binId) {
        UsagePatternModel model = getLatestModelForBin(binId);
        return model.getAvgDailyIncreaseWeekday();
    }
}
