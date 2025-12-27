// package com.example.demo.service.impl;

// import org.springframework.stereotype.Service;
// import com.example.demo.model.Bin;
// import com.example.demo.repository.BinRepository;

// import java.util.List;
// import java.util.Optional;

// @Service // Correct annotation for services
// public class BinServiceImpl {

//     private final BinRepository binRepository;

//     public BinServiceImpl(BinRepository binRepository) {
//         this.binRepository = binRepository;
//     }

//     public Bin createBin(Bin bin) {
//         return binRepository.save(bin);
//     }

//     public Optional<Bin> getBinById(Long id) {
//         return binRepository.findById(id);
//     }

//     public List<Bin> getAllBins() {
//         return binRepository.findAll();
//     }

//     public Bin updateBin(Long id, Bin updated) {
//         Bin existing = binRepository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Bin not found"));
//         existing.setName(updated.getName());
//         existing.setCapacity(updated.getCapacity());
//         return binRepository.save(existing);
//     }

//     public void deactivateBin(Long id) {
//         Bin existing = binRepository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Bin not found"));
//         existing.setActive(false);
//         binRepository.save(existing);
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.model.Bin;
import com.example.demo.repository.BinRepository;
import com.example.demo.service.BinService;

import java.util.List;
import java.util.Optional;

public class BinServiceImpl implements BinService {
    
    private final BinRepository binRepository;
    
    public BinServiceImpl(BinRepository binRepository) {
        this.binRepository = binRepository;
    }
    
    @Override
    public Bin createBin(Bin bin) {
        return binRepository.save(bin);
    }
    
    @Override
    public List<Bin> getAllBins() {
        return binRepository.findAll();
    }
    
    @Override
    public Optional<Bin> getBinById(Long id) {
        return binRepository.findById(id);
    }
    
    @Override
    public Bin updateBinFillLevel(Long binId, Double newFillLevel) {
        return binRepository.findById(binId).map(bin -> {
            bin.setCurrentFillLevel(newFillLevel);
            return binRepository.save(bin);
        }).orElseThrow(() -> new RuntimeException("Bin not found"));
    }
    
    @Override
    public void deleteBin(Long id) {
        binRepository.deleteById(id);
    }
    
    @Override
    public List<Bin> getBinsNeedingCollection() {
        return binRepository.findByCurrentFillLevelGreaterThanEqual(80.0);
    }
}