package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Bin;
import com.example.demo.model.UsagePatternModel;
import com.example.demo.repository.BinRepository;
import com.example.demo.repository.UsagePatternModelRepository;

@Service
public class UsagePatternModelServiceImpl {

    @Autowired
    private UsagePatternModelRepository repository;

    @Autowired
    private BinRepository binRepository;

    public UsagePatternModel createModel(UsagePatternModel model, Long binId) {
        return repository.save(model);
    }

    public UsagePatternModel createModel(UsagePatternModel model) {
        return repository.save(model);
    }

    public UsagePatternModel updateModel(long id, UsagePatternModel model) {
        model.setId(id);
        return repository.save(model);
    }

    public UsagePatternModel getModelForBin(long binId) {
        Bin bin = binRepository.findById(binId).orElse(null);
        return repository.findTop1ByBinOrderByLastUpdatedDesc(bin).orElse(null);
    }
}
