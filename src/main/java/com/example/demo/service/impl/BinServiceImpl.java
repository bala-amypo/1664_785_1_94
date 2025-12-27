package com.example.demo.service.impl;

import com.example.demo.model.Bin;
import com.example.demo.repository.BinRepository;
import com.example.demo.repository.ZoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BinServiceImpl {

    private final BinRepository binRepository;
    private final ZoneRepository zoneRepository;

    public BinServiceImpl(BinRepository binRepository,
                          ZoneRepository zoneRepository) {
        this.binRepository = binRepository;
        this.zoneRepository = zoneRepository;
    }

    public Bin createBin(Bin bin) {
        return binRepository.save(bin);
    }

    public Bin getBinById(Long id) {
        return binRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bin not found"));
    }

    public List<Bin> getAllBins() {
        return binRepository.findAll();
    }

    public Bin updateBin(Long id, Bin updated) {
        Bin bin = getBinById(id);
        bin.setName(updated.getName());
        bin.setCapacity(updated.getCapacity());
        return binRepository.save(bin);
    }

    public void deactivateBin(Long id) {
        Bin bin = getBinById(id);
        bin.setActive(false);
        binRepository.save(bin);
    }
}
