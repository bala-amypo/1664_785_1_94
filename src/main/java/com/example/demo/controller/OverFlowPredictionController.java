package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/predictions")

public class OverFlowPredictionController {

    private final OverFlowPredictionService overflowPredictionService;

    public OverFlowPredictionController(OverFlowPredictionService overflowPredictionService) {
        this.overflowPredictionService = overflowPredictionService;
    }

    @PostMapping("/generate/{binId}")
    public OverFlowPrediction generatePrediction(@PathVariable Long binId) {
        return overflowPredictionService.generatePrediction(binId);
    }

    @GetMapping("/{id}")
    public OverFlowPrediction getPrediction(@PathVariable Long id) {
        return overflowPredictionService.getPredictionById(id);
    }

    @GetMapping("/bin/{binId}")
    public List<OverFlowPrediction> getPredictionsForBin(@PathVariable Long binId) {
        return overflowPredictionService.getPredictionsForBin(binId);
    }

    @GetMapping("/zone/{zoneId}/latest")
    public List<OverFlowPrediction> getLatestPredictionsForZone(
            @PathVariable Long zoneId
    ) {
        return overflowPredictionService.getLatestPredictionsForZone(zoneId);
    }
}
