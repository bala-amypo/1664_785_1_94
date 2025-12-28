package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Bin;
import com.example.demo.repository.BinRepository;
import com.example.demo.service.BinService;

@Service
public class BinServiceImpl implements BinService {

    private final BinRepository binRepository;

    public BinServiceImpl(BinRepository binRepository) {
        this.binRepository = binRepository;
    }

    @Override
    public Bin createBin(Bin bin) {
        return binRepository.save(bin);
    }

    @Override
    public Bin getBinById(Long id) {
        return binRepository.findById(id).orElse(null);
    }

    @Override
    public List<Bin> getAllBins() {
        return binRepository.findAll();
    }

    @Override
    public Bin updateBin(Long id, Bin bin) {
        Bin existing = getBinById(id);
        if (existing == null) return null;

        existing.setLocation(bin.getLocation());
        existing.setCapacity(bin.getCapacity());
        existing.setCurrentFillLevel(bin.getCurrentFillLevel());
        return binRepository.save(existing);
    }

    @Override
    public void deleteBin(Long id) {
        binRepository.deleteById(id);
    }
}
