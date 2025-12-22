package com.example.demo.controller;

import com.example.demo.model.OverFlowPrediction;
import com.example.demo.service.OverFlowPredictionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/predictions")
@Tag(name = "Overflow Predictions")
public class OverFlowPredictionController {

    private final OverFlowPredictionService predictionService;

    public OverFlowPredictionController(OverFlowPredictionService predictionService) {
        this.predictionService = predictionService;
    }

    @PostMapping("/generate/{binId}")
    public OverFlowPrediction generatePrediction(@PathVariable Long binId) {
        return predictionService.generatePrediction(binId);
    }

    @GetMapping("/{id}")
    public OverFlowPrediction getPrediction(@PathVariable Long id) {
        return predictionService.getPredictionById(id);
    }

    @GetMapping("/bin/{binId}")
    public List<OverFlowPrediction> getPredictionsForBin(
            @PathVariable Long binId) {
        return predictionService.getPredictionsForBin(binId);
    }

    @GetMapping("/zone/{zoneId}/latest")
    public List<OverFlowPrediction> getLatestPredictionsForZone(
            @PathVariable Long zoneId) {
        return predictionService.getLatestPredictionsForZone(zoneId);
    }
}
