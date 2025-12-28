package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Zone;
import com.example.demo.repository.ZoneRepository;

@Service
public class ZoneServiceImpl {

    @Autowired
    private ZoneRepository zoneRepository;

    public Zone getZoneById(long id) {
        return zoneRepository.findById(id).orElse(null);
    }
}
