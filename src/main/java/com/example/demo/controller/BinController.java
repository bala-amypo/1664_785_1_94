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

    private final BinService BinService;

    public BinController(BinService binService) {
        this.BinService = BinService;
    }

    @PostMapping
    public Bin createBin(@RequestBody Bin bin) {
        return BinService.createBin(bin);
    }

    @PutMapping("/{id}")
    public Bin updateBin(@PathVariable Long id, @RequestBody Bin bin) {
        return BinService.updateBin(id, bin);
    }

    @GetMapping("/{id}")
    public Bin getBin(@PathVariable Long id) {
        return BinService.getBinById(id);
    }

    @GetMapping
    public List<Bin> getAllBins() {
        return BinService.getAllBins();
    }

    @PutMapping("/{id}/deactivate")
    public void deactivateBin(@PathVariable Long id) {
        BinService.deactivateBin(id);
    }
}
