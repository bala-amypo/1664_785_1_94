package com.example.demo.controller;

import com.example.demo.model.Bin;
import com.example.demo.service.BinService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bins")
@Tag(name = "Bins")
public class BinController {

    private final BinService binService; // lowercase variable

    public BinController(BinService binService) {
        this.binService = binService; // assign correctly
    }

    @PostMapping
    public Bin createBin(@RequestBody Bin bin) {
        return binService.createBin(bin); // use lowercase parameter
    }

    @PutMapping("/{id}")
    public Bin updateBin(@PathVariable Long id, @RequestBody Bin bin) {
        return binService.updateBin(id, bin); // use lowercase parameter
    }

    @GetMapping("/{id}")
    public Bin getBin(@PathVariable Long id) {
        return binService.getBinById(id);
    }

    @GetMapping
    public List<Bin> getAllBins() {
        return binService.getAllBins();
    }

    @PutMapping("/{id}/deactivate")
    public void deactivateBin(@PathVariable Long id) {
        binService.deactivateBin(id);
    }
}
