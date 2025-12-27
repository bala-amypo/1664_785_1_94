package com.example.demo.service.impl;

import com.example.demo.model.Bin;
import com.example.demo.model.UsagePatternModel;
import com.example.demo.repository.BinRepository;
import com.example.demo.repository.UsagePatternModelRepository;
import com.example.demo.service.UsagePatternModelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsagePatternModelServiceImpl implements UsagePatternModelService {

    private final UsagePatternModelRepository usagePatternModelRepository;
    private final BinRepository binRepository;

    public UsagePatternModelServiceImpl(UsagePatternModelRepository usagePatternModelRepository,
                                        BinRepository binRepository) {
        this.usagePatternModelRepository = usagePatternModelRepository;
        this.binRepository = binRepository;
    }

    @Override
    public UsagePatternModel createModel(UsagePatternModel model, Long binId) {
        Bin bin = binRepository.findById(binId)
                .orElseThrow(() -> new RuntimeException("Bin not found with id: " + binId));

        model.setBin(bin);
        return usagePatternModelRepository.save(model);
    }

    @Override
    public UsagePatternModel updateModel(Long id, UsagePatternModel model) {
        UsagePatternModel existing = getUsagePatternModelById(id);

        existing.setAvgDailyIncreaseWeekday(model.getAvgDailyIncreaseWeekday());
        existing.setAvgDailyIncreaseWeekend(model.getAvgDailyIncreaseWeekend());
        existing.setLastUpdated(model.getLastUpdated());

        return usagePatternModelRepository.save(existing);
    }

    @Override
    public UsagePatternModel getUsagePatternModelById(Long id) {
        return usagePatternModelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UsagePatternModel not found with id: " + id));
    }

    @Override
    public UsagePatternModel getModelForBin(Long binId) {
        return usagePatternModelRepository
                .findTopByBinIdOrderByLastUpdatedDesc(binId).orElseThrow(() -> new RuntimeException("No model found for bin id: " + binId));
    }

    @Override
    public List<UsagePatternModel> getAllModels() {
        return usagePatternModelRepository.findAll();
    }
}
