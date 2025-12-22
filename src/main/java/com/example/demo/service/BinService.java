package com.example.demo.service;

import com.example.demo.model.Bin;

public interface BinService {
    Bin getBinById(Long id);
    Bin updateBin(Long id, Bin bin);
}
