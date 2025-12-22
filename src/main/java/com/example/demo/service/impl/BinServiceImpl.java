package com.example.demo.service.impl;

import com.example.demo.model.Bin;
import com.example.demo.repository.BinRepository;
import com.example.demo.service.BinService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BinServiceImpl implements BinService {

    @Autowired
    private BinRepository binRepository;

    @Override
    public Bin getBinById(Long id) {
        return binRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bin not found with id: " + id));
    }

    @Override
    public Bin updateBin(Long id, Bin bin) {
        Bin existingBin = binRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bin not found with id: " + id));

        existingBin.setName(bin.getName());
        existingBin.setLocation(bin.getLocation());
        existingBin.setCapacity(bin.getCapacity());
        

        return binRepository.save(existingBin);
    }
}
