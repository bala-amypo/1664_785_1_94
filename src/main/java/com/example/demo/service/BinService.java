package com.example.demo.servie;



public interface BinService {

    Bin createBin(Bin bin);

    Bin getBinById(Long id);

    Bin getBinByIdentifier(String identifier);

    List<Bin> getAllBins();

    void deactivateBin(Long id);
}
