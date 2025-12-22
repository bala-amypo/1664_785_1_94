package com.example.demo.service.impl;

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
        bin.setActive(true);
        return binRepository.save(bin);
    }

    @Override
    public List<Bin> getAllBins() {
        return binRepository.findAll();
    }
}
