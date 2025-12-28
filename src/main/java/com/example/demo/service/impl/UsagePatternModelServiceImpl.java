package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Bin;
import com.example.demo.model.UsagePatternModel;
import com.example.demo.repository.BinRepository;
import com.example.demo.repository.UsagePatternModelRepository;
import com.example.demo.service.UsagePatternModelService;

@Service
public class UsagePatternModelServiceImpl implements UsagePatternModelService {

    private final UsagePatternModelRepository usagePatternModelRepository;
    private final BinRepository binRepository;

    public UsagePatternModelServiceImpl(
            UsagePatternModelRepository usagePatternModelRepository,
            BinRepository binRepository) {
        this.usagePatternModelRepository = usagePatternModelRepository;
        this.binRepository = binRepository;
    }

    @Override
    public UsagePatternModel createModel(UsagePatternModel model, Long binId) {
        Bin bin = binRepository.findById(binId).orElse(null);
        if (bin == null) {
            return null;
        }
        model.setBin(bin);
        return usagePatternModelRepository.save(model);
    }

    @Override
    public UsagePatternModel getModelById(Long id) {
        return usagePatternModelRepository.findById(id).orElse(null);
    }

    @Override
    public List<UsagePatternModel> getAllModels() {
        return usagePatternModelRepository.findAll();
    }

    @Override
    public Optional<UsagePatternModel> getLatestModelForBin(Long binId) {
        return binRepository.findById(binId)
                .flatMap(bin ->
                        usagePatternModelRepository
                                .findTopByBinOrderByLastUpdatedDesc(bin));
    }

    @Override
    public void deleteModel(Long id) {
        usagePatternModelRepository.deleteById(id);
    }
}
