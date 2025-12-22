package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Bin;
import com.example.demo.repository.BinRepository;
import com.example.demo.service.BinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  
public class BinServiceImpl implements BinService {

    @Autowired
    private BinRepository binRepository;

    @Override
    public Bin createBin(Bin bin) {
        bin.setActive(true);   // default active
        return binRepository.save(bin);
    }

    @Override
    public Bin updateBin(Long id, Bin bin) {
        Bin existingBin = binRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Bin not found with id: " + id));

        existingBin.setName(bin.getName());
        existingBin.setLocation(bin.getLocation());
        existingBin.setCapacity(bin.getCapacity());

        return binRepository.save(existingBin);
    }

    @Override
    public Bin getBinById(Long id) {
        return binRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Bin not found with id: " + id));
    }

    @Override
    public List<Bin> getAllBins() {
        return binRepository.findAll();
    }

    @Override
    public void deactivateBin(Long id) {
        Bin bin = binRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Bin not found with id: " + id));

        bin.setActive(false);
        binRepository.save(bin);
    }
}
