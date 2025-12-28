package com.example.demo.controller;

import com.example.demo.model.OverflowPrediction;
import com.example.demo.service.OverflowPredictionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/overflow-predictions")
public class OverflowPredictionController {

    private final OverflowPredictionService overflowPredictionService;

    public OverflowPredictionController(
            OverflowPredictionService overflowPredictionService) {
        this.overflowPredictionService = overflowPredictionService;
    }

    // CREATE OVERFLOW PREDICTION
    @PostMapping
    public OverflowPrediction createPrediction(
            @RequestBody OverflowPrediction prediction) {

        return overflowPredictionService.createPrediction(prediction);
    }

    // GET LATEST PREDICTIONS FOR A ZONE
    @GetMapping("/zone/{zoneId}")
    public List<OverflowPrediction> getPredictionsForZone(
            @PathVariable Long zoneId) {

        return overflowPredictionService
                .getLatestPredictionsForZone(zoneId);
    }
}
