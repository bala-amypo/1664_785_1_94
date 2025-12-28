package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.OverflowPrediction;
import com.example.demo.service.OverflowPredictionService;

@RestController
@RequestMapping("/api/predictions")
public class OverflowPredictionController {

    private final OverflowPredictionService service;

    public OverflowPredictionController(OverflowPredictionService service) {
        this.service = service;
    }

    @PostMapping
    public OverflowPrediction create(@RequestBody OverflowPrediction prediction) {
        return service.createPrediction(prediction);
    }

    @GetMapping
    public List<OverflowPrediction> getAll() {
        return service.getAllPredictions();
    }

    @GetMapping("/{id}")
    public OverflowPrediction getById(@PathVariable Long id) {
        return service.getPredictionById(id);
    }

    @GetMapping("/zone/{zoneId}")
    public List<OverflowPrediction> getByZone(@PathVariable Long zoneId) {
        return service.getLatestPredictionsForZone(zoneId);
    }
}
