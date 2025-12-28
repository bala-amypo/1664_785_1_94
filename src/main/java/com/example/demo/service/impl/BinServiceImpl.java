package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.model.Bin;
import com.example.demo.model.Zone;
import com.example.demo.repository.BinRepository;
import com.example.demo.repository.ZoneRepository;
import com.example.demo.service.BinService;

@Service
public class BinServiceImpl implements BinService {

    private final BinRepository binRepository;
    private final ZoneRepository zoneRepository;

    public BinServiceImpl(BinRepository binRepository,
                          ZoneRepository zoneRepository) {
        this.binRepository = binRepository;
        this.zoneRepository = zoneRepository;
    }

    @Override
    public Bin createBin(Bin bin, Long zoneId) {
        Zone zone = zoneRepository.findById(zoneId).orElse(null);
        bin.setZone(zone);
        return binRepository.save(bin);
    }

    @Override
    public Bin updateBin(Long id, Bin update) {
        Bin existing = binRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setIdentifier(update.getIdentifier());
            existing.setCapacityLiters(update.getCapacityLiters());
            existing.setLatitude(update.getLatitude());
            existing.setLongitude(update.getLongitude());
            existing.setLocationDescription(update.getLocationDescription());
            return binRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deactivateBin(long id) {
        Bin bin = binRepository.findById(id).orElse(null);
        if (bin != null) {
            bin.setActive(false);
            binRepository.save(bin);
        }
    }
}
