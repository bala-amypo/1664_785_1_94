package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.OverflowPrediction;
import com.example.demo.service.OverflowPredictionService;

@RestController
@RequestMapping("/api/predictions")
public class OverflowPredictionController {

    @Autowired
    private OverflowPredictionService predictionService;

    @PostMapping("/generate/{binId}")
    public OverflowPrediction generatePrediction(@PathVariable Long binId) {
        return predictionService.generatePrediction(binId);
    }
}
