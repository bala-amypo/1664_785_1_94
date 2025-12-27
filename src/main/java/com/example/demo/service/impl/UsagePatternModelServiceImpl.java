package com.example.demo.service.impl;

import com.example.demo.model.UsagePatternModel;
import org.springframework.stereotype.Service;
import com.example.demo.service.UsagePatternModelService ;
import java.util.HashMap;
import java.util.Map;

@Service
public class UsagePatternModelServiceImpl implements UsagePatternModelService {

    private final Map<Long, UsagePatternModel> usageMap = new HashMap<>();

    public double calculateDailyIncrease(UsagePatternModel model) {
        return model.getAvgDailyIncreaseWeekday();
    }
}
