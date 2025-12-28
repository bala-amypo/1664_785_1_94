package com.example.demo.service.impl;

import com.example.demo.model.Bin;
import com.example.demo.repository.BinRepository;

public class BinServiceImpl {

    private final BinRepository binRepository;

    public BinServiceImpl(BinRepository binRepository) {
        this.binRepository = binRepository;
    }

    public Bin createBin(Bin bin) {
        return binRepository.save(bin);
    }
}
