package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Bin;

public interface BinService {

    // CREATE
    Bin createBin(Bin bin);

    // READ
    Bin getBinById(Long id);
    List<Bin> getAllBins();

    // UPDATE
    Bin updateBin(Long id, Bin update);

    // DELETE
    void deleteBin(Long id);

    // EXTRA (used by tests)
    void deactivateBin(long id);
}
