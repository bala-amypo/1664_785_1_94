package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.UsagePatternModel;
import com.example.demo.repository.UsagePatternModelRepository;
import com.example.demo.service.UsagePatternModelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsagePatternModelServiceImpl implements UsagePatternModelService {

    private final UsagePatternModelRepository repository;

    public UsagePatternModelServiceImpl(UsagePatternModelRepository repository) {
        this.repository = repository;
    }

    @Override
    public UsagePatternModel createModel(UsagePatternModel model) {
        if (model.getDailyIncrease() < 0) {
            throw new BadRequestException("Negative increase not allowed");
        }
        return repository.save(model);
    }

    @Override
    public UsagePatternModel updateModel(Long id, UsagePatternModel model) {
        UsagePatternModel existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Model not found"));
        existing.setDailyIncrease(model.getAvgDailyIncreaseWeekday());
        return repository.save(existing);
    }

    @Override
    public UsagePatternModel getModelForBin(Long binId) {
        return repository.findTop1ByBinOrderByLastUpdatedDesc(binId);
    }

    @Override
    public List<UsagePatternModel> getAllModels() {
        return repository.findAll();
    }
}
