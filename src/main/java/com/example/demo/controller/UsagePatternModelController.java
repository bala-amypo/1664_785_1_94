package com.example.demo.controller;

import com.example.demo.model.UsagePatternModel;
import com.example.demo.service.UsagePatternModelService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/usage-pattern-models")
public class UsagePatternModelController {

    private final UsagePatternModelService usagePatternModelService;

    public UsagePatternModelController(
            UsagePatternModelService usagePatternModelService) {
        this.usagePatternModelService = usagePatternModelService;
    }

    // CREATE MODEL FOR A BIN
    @PostMapping("/{binId}")
    public UsagePatternModel createModel(
            @RequestBody UsagePatternModel model,
            @PathVariable Long binId) {

        return usagePatternModelService.createModel(model, binId);
    }

    // GET LATEST MODEL FOR A BIN
    @GetMapping("/latest/{binId}")
    public Optional<UsagePatternModel> getLatestModel(
            @PathVariable Long binId) {

        return usagePatternModelService.getLatestModelForBin(binId);
    }
}
