// package com.example.demo.controller;

// import org.springframework.web.bind.annotation.*;
// import com.example.demo.model.Bin;
// import com.example.demo.service.impl.BinServiceImpl;

// import java.util.List;

// @RestController
// @RequestMapping("/bins")
// public class BinController {

//     private final BinServiceImpl binService;

//     public BinController(BinServiceImpl binService) {
//         this.binService = binService;
//     }

//     @PostMapping
//     public Bin createBin(@RequestBody Bin bin) {
//         return binService.createBin(bin);
//     }

//     @GetMapping("/{id}")
//     public Bin getBinById(@PathVariable Long id) {
//         // Unwrap Optional here
//         return binService.getBinById(id)
//                 .orElseThrow(() -> new RuntimeException("Bin not found"));
//     }

//     @GetMapping
//     public List<Bin> getAllBins() {
//         return binService.getAllBins();
//     }

//     @PutMapping("/{id}")
//     public Bin updateBin(@PathVariable Long id, @RequestBody Bin updated) {
//         return binService.updateBin(id, updated);
//     }

//     @DeleteMapping("/{id}")
//     public void deactivateBin(@PathVariable Long id) {
//         binService.deactivateBin(id);
//     }
// }

package com.example.demo.controller;

import com.example.demo.model.Bin;
import com.example.demo.service.BinService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bins")
public class BinController {

    private final BinService binService;

    public BinController(BinService binService) {
        this.binService = binService;
    }

    @PostMapping
    public Bin createBin(@RequestBody Bin bin) {
        return binService.createBin(bin);
    }

    @GetMapping("/{id}")
    public Bin getBinById(@PathVariable Long id) {
        return binService.getBinById(id);
    }

    @GetMapping
    public List<Bin> getAllBins() {
        return binService.getAllBins();
    }

    @PutMapping("/{id}")
    public Bin updateBin(@PathVariable Long id, @RequestBody Bin bin) {
        return binService.updateBin(id, bin);
    }

    @DeleteMapping("/{id}")
    public void deleteBin(@PathVariable Long id) {
        binService.deleteBin(id);
    }
}
