package com.example.demo.service.impl;

import com.example.demo.model.Bin;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class BinServiceImpl {

    private final Map<Long, Bin> bins = new HashMap<>();
    private long counter = 1;

    public Bin createBin(Bin bin) {
        bins.put(counter, bin);
        counter++;
        return bin;
    }

    public Bin getBinById(Long id) {
        return bins.get(id);
    }

    public List<Bin> getAllBins() {
        return new ArrayList<>(bins.values());
    }

    public Bin updateBin(Long id, Bin updated) {
        Bin existing = bins.get(id);
        if (existing != null) {
            existing.setName(updated.getName());
            existing.setCapacity(updated.getCapacity());
        }
        return existing;
    }

    public void deactivateBin(Long id) {
        Bin bin = bins.get(id);
        if (bin != null) bin.setActive(false);
    }
}
