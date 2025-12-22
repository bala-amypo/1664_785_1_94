package com.example.demo.service.impl;

import com.example.demo.model.Bin;
import com.example.demo.repository.BinRepository;
import com.example.demo.service.BinService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface BinService {
    Bin createBin(Bin bin);
    List<Bin> getAllBins();
    Bin getBinById(Long id);
    Bin updateBin(Long id, Bin bin);
    void deactivateBin(Long id);
}


    @Autowired
    private BinRepository binRepository;

  @Override
public Bin createBin(Bin bin) {
    return binRepository.save(bin);
}

@Override
public List<Bin> getAllBins() {
    return binRepository.findAll();
}

@Override
public void deactivateBin(Long id) {
    Bin existingBin = binRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Bin not found with id: " + id));
    existingBin.setActive(false); // assuming Bin has an "active" field
    binRepository.save(existingBin);
}
