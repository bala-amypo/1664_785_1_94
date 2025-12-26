package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Bin;
import com.example.demo.model.UsagePatternModel;
import com.example.demo.repository.BinRepository;
import com.example.demo.repository.UsagePatternModelRepository;
import com.example.demo.service.UsagePatternModelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsagePatternModelServiceImpl implements UsagePatternModelService {
    private final UsagePatternModelRepository repository;
    private final BinRepository binRepository;

    public UsagePatternModelServiceImpl(
            UsagePatternModelRepository repository,
            BinRepository binRepository) {
        this.repository = repository;
        this.binRepository = binRepository;
    }

    @Override
    public UsagePatternModel createModel(UsagePatternModel model, Long binId) {
        Bin bin = binRepository.findById(binId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Bin not found"));

        model.setBin(bin);
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
    public UsagePatternModel getModelForBin(Long binId) {
        return repository.findTopByBinIdOrderByLastUpdatedDesc(binId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No model found for bin"));
    }

    @Override
    public List<UsagePatternModel> getAllModels() {
        return repository.findAll();
    }
}
