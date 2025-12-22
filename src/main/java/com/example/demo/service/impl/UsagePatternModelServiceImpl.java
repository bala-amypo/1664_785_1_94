package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Bin;
import com.example.demo.model.UsagePatternModel;
import com.example.demo.repository.BinRepository;
import com.example.demo.repository.UsagePatternModelRepository;
import com.example.demo.service.UsagePatternModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsagePatternModelServiceImpl implements UsagePatternModelService {

    @Autowired
    private UsagePatternModelRepository modelRepository;

    @Autowired
    private BinRepository binRepository;

    @Override
    public UsagePatternModel createModel(UsagePatternModel model, Long binId) {
        Bin bin = binRepository.findById(binId)
                .orElseThrow(() -> new ResourceNotFoundException("Bin not found with id " + binId));
        model.setBin(bin);
        model.setCreatedAt(LocalDateTime.now());
        return modelRepository.save(model);
    }

    @Override
    public UsagePatternModel getModelForBin(Long binId) {
        return modelRepository.findByBinId(binId);
    }

    @Override
    public UsagePatternModel getUsagePatternModelById(Long id) {
        return modelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UsagePatternModel not found with id " + id));
    }

    @Override
    public List<UsagePatternModel> getAllModels() {
        return modelRepository.findAll();
    }

    @Override
    public UsagePatternModel updateModel(Long id, UsagePatternModel model) {
        UsagePatternModel existingModel = modelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UsagePatternModel not found with id " + id));

        // Make sure your UsagePatternModel has these fields:
        existingModel.setModelName(model.getModelName()); // instead of getName()
        existingModel.setPattern(model.getPattern());     // instead of getPatternData()
        existingModel.setUpdatedAt(LocalDateTime.now());  // make sure setUpdatedAt exists

        return modelRepository.save(existingModel);
    }
}
