package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.UsagePatternModelService;

import java.util.Optional;

public class UsagePatternModelServiceImpl
        implements UsagePatternModelService {

    private final UsagePatternModelRepository usagePatternModelRepository;
    private final BinRepository binRepository;

    // ⚠ Constructor EXACTLY matches test
    public UsagePatternModelServiceImpl(
            UsagePatternModelRepository usagePatternModelRepository,
            BinRepository binRepository) {
        this.usagePatternModelRepository = usagePatternModelRepository;
        this.binRepository = binRepository;
    }

    @Override
    public UsagePatternModel createModel(
            UsagePatternModel model, Long binId) {

        binRepository.findById(binId)
                .ifPresent(model::setBin);

        return usagePatternModelRepository.save(model);
    }

    @Override
    public Optional<UsagePatternModel>
    getLatestModelForBin(Long binId) {

        return binRepository.findById(binId)
                .flatMap(bin ->
                    usagePatternModelRepository
                        .findTopByBinOrderByLastUpdatedDesc(bin));
    }
}
