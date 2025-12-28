package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Bin;
import com.example.demo.model.UsagePatternModel;
import com.example.demo.repository.BinRepository;
import com.example.demo.repository.UsagePatternModelRepository;
import com.example.demo.service.UsagePatternModelService;

import java.util.List;

public class UsagePatternModelServiceImpl implements UsagePatternModelService {

    private final UsagePatternModelRepository modelRepository;
    private final BinRepository binRepository;

    public UsagePatternModelServiceImpl(
            UsagePatternModelRepository modelRepository,
            BinRepository binRepository) {
        this.modelRepository = modelRepository;
        this.binRepository = binRepository;
    }

    @Override
    public UsagePatternModel createModel(UsagePatternModel model) {
        validate(model);

        Bin bin = binRepository.findById(model.getBin().getId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Bin not found"));

        model.setBin(bin);
        return modelRepository.save(model);
    }

    @Override
    public UsagePatternModel updateModel(Long id, UsagePatternModel updated) {
        UsagePatternModel model = modelRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Model not found"));

        validate(updated);

        model.setAvgDailyIncreaseWeekday(updated.getAvgDailyIncreaseWeekday());
        model.setAvgDailyIncreaseWeekend(updated.getAvgDailyIncreaseWeekend());
        model.setLastUpdated(updated.getLastUpdated());

        return modelRepository.save(model);
    }

    @Override
    public UsagePatternModel getModelForBin(Long binId) {
        Bin bin = binRepository.findById(binId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Bin not found"));

        return modelRepository
                .findTop1ByBinOrderByLastUpdatedDesc(bin)
                .orElseThrow(() ->
                        new ResourceNotFoundException("UsagePatternModel not found"));
    }

    @Override
    public List<UsagePatternModel> getAllModels() {
        return modelRepository.findAll();
    }

    private void validate(UsagePatternModel model) {
        if (model.getAvgDailyIncreaseWeekday() < 0 ||
            model.getAvgDailyIncreaseWeekend() < 0) {
            throw new BadRequestException("daily increase must be >= 0");
        }
    }
}
