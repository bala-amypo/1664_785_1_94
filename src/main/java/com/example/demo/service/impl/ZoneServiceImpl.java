package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Zone;
import com.example.demo.repository.ZoneRepository;
import com.example.demo.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  
public class ZoneServiceImpl implements ZoneService {

    @Autowired
    private ZoneRepository zoneRepository;

    @Override
    public Zone createZone(Zone zone) {
        zone.setActive(true);   // default active
        return zoneRepository.save(zone);
    }

    @Override
    public Zone updateZone(Long id, Zone zone) {

        Zone existingZone = zoneRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Zone not found with id: " + id));

        existingZone.setName(zone.getName());
        existingZone.setDescription(zone.getDescription());

        return zoneRepository.save(existingZone);
    }

    @Override
    public Zone getZoneById(Long id) {
        return zoneRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Zone not found with id: " + id));
    }

    @Override
    public List<Zone> getAllZones() {
        return zoneRepository.findAll();
    }

    @Override
    public void deactivateZone(Long id) {

        Zone zone = zoneRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Zone not found with id: " + id));

        zone.setActive(false);
        zoneRepository.save(zone);
    }
}
