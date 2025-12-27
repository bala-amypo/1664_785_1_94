// package com.example.demo.service;

// import com.example.demo.model.Bin;
// import java.util.List;

// public interface BinService {
//     Bin createBin(Bin bin);
//     List<Bin> getAllBins();
//     Bin getBinById(Long id);
//     Bin updateBin(Long id, Bin bin);
//     void deactivateBin(Long id);
// }
package com.example.demo.service;

import com.example.demo.model.Bin;

import java.util.List;

public interface BinService {
    Bin createBin(Bin bin);
    List<Bin> getAllBins();
    Optional<Bin> getBinById(Long id);
    Bin updateBinFillLevel(Long binId, Double newFillLevel);
    void deleteBin(Long id);
    List<Bin> getBinsNeedingCollection();
}