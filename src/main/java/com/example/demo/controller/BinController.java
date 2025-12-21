package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Bin;
import com.example.demo.service.BinService;

@RestController
@RequestMapping("/bins")
public class BinController {

    @Autowired
    private BinService binService;

    @PostMapping
    public Bin createBin(@RequestBody Bin bin) {
        return binService.saveBin(bin);
    }

    @GetMapping
    public List<Bin> getAllBins() {
        return binService.getAllBins();
    }
}
