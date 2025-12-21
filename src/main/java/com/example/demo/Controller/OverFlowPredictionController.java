package com.example.demo.controller;



@RestController
@RequestMapping("/api/predictions")
@Tag(name = "Overflow Predictions")
public class OverflowPredictionController {

    private final OverflowPredictionService overflowPredictionService;

    public OverflowPredictionController(OverflowPredictionService overflowPredictionService) {
        this.overflowPredictionService = overflowPredictionService;
    }

    @PostMapping("/generate/{binId}")
    public OverflowPrediction generatePrediction(@PathVariable Long binId) {
        return overflowPredictionService.generatePrediction(binId);
    }

    @GetMapping("/{id}")
    public OverflowPrediction getPrediction(@PathVariable Long id) {
        return overflowPredictionService.getPredictionById(id);
    }

    @GetMapping("/bin/{binId}")
    public List<OverflowPrediction> getPredictionsForBin(@PathVariable Long binId) {
        return overflowPredictionService.getPredictionsForBin(binId);
    }

    @GetMapping("/zone/{zoneId}/latest")
    public List<OverflowPrediction> getLatestPredictionsForZone(
            @PathVariable Long zoneId
    ) {
        return overflowPredictionService.getLatestPredictionsForZone(zoneId);
    }
}
