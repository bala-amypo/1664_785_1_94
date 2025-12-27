package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.model.Bin;
import com.example.demo.repository.BinRepository;

import java.util.List;
import java.util.Optional;

@Service // Correct annotation for services
public class BinServiceImpl {

    private final BinRepository binRepository;

    public BinServiceImpl(BinRepository binRepository) {
        this.binRepository = binRepository;
    }

    public Bin createBin(Bin bin) {
        return binRepository.save(bin);
    }

    public Optional<Bin> getBinById(Long id) {
        return binRepository.findById(id);
    }

    public List<Bin> getAllBins() {
        return binRepository.findAll();
    }

    public Bin updateBin(Long id, Bin updated) {
        Bin existing = binRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bin not found"));
        existing.setName(updated.getName());
        existing.setCapacity(updated.getCapacity());
        return binRepository.save(existing);
    }

    public void deactivateBin(Long id) {
        Bin existing = binRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bin not found"));
        existing.setActive(false);
        binRepository.save(existing);
    }
}
