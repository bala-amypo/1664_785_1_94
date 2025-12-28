package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.model.Zone;
import com.example.demo.repository.ZoneRepository;

@Service
public class ZoneServiceImpl {

    private final ZoneRepository zoneRepository;

    // 🔹 Constructor required by tests
    public ZoneServiceImpl(ZoneRepository zoneRepository) {
        this.zoneRepository = zoneRepository;
    }

    // ✅ Used by tests
    public Zone createZone(Zone zone) {
        return zoneRepository.save(zone);
    }

    // ✅ Used by tests
    public Zone updateZone(Long id, Zone update) {
        Zone existing = zoneRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setZoneName(update.getZoneName());
            existing.setDescription(update.getDescription());
            existing.setActive(update.getActive());
            return zoneRepository.save(existing);
        }
        return null;
    }

    // ✅ Used by tests
    public void deactivateZone(Long id) {
        Zone zone = zoneRepository.findById(id).orElse(null);
        if (zone != null) {
            zone.setActive(false);
            zoneRepository.save(zone);
        }
    }
}
