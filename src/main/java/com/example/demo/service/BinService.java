package com.example.demo.service;

import com.example.demo.model.Bin;

public interface BinService {

    Bin createBin(Bin bin, Long zoneId);

    Bin updateBin(Long id, Bin update);

    void deactivateBin(long id);
}
