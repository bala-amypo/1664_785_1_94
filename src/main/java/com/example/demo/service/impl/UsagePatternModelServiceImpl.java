package com.example.demo.service.impl;

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
    public UsagePatternModel createUsagePatternModel(UsagePatternModel model) {
        return repository.save(model);
    }

    @Override
    public UsagePatternModel updateModel(Long id, UsagePatternModel model) {
        UsagePatternModel existing = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("UsagePatternModel not found"));

        existing.setAvgDailyIncreaseWeekday(model.getAvgDailyIncreaseWeekday());
        existing.setLastUpdated(model.getLastUpdated());

        return repository.save(existing);
    }

    @Override
    public UsagePatternModel getUsagePatternModelById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("UsagePatternModel not found"));
    }

    @Override
    public UsagePatternModel getLatestModelForBin(Long binId) {
        return repository.findTopByBinIdOrderByLastUpdatedDesc(binId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No model found for bin " + binId));
    }

    @Override
    public List<UsagePatternModel> getAllModels() {
        return repository.findAll();
    }
}
