package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/models")

public class UsagePatternModelController {

    private final UsagePatternModelService usagePatternModelService;

    public UsagePatternModelController(UsagePatternModelService usagePatternModelService) {
        this.usagePatternModelService = usagePatternModelService;
    }

    @PostMapping
    public UsagePatternModelConroller createModel(@RequestBody UsagePatternModel model) {
        return usagePatternModelService.createModel(model);
    }

    @PutMapping("/{id}")
    public UsagePatternModel updateModel(
            @PathVariable Long id,
            @RequestBody UsagePatternModel model,
    ) {
        return usagePatternModelService.updateModel(id, model);
    }

    @GetMapping("/bin/{binId}")
    public UsagePatternModel getModelForBin(@PathVariable Long binId) {
        return usagePatternModelService.getModelForBin(binId);
    }

    @GetMapping
    public List<UsagePatternModel> getAllModels() {
        return usagePatternModelService.getAllModels();
    }
}
