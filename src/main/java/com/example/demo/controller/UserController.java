package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.UsagePatternModel;
import com.example.demo.service.UsagePatternModelService;

@RestController
@RequestMapping("/api/models")
public class UsagePatternModelController {

    private final UsagePatternModelService service;

    public UsagePatternModelController(UsagePatternModelService service) {
        this.service = service;
    }

    @PostMapping("/{binId}")
    public UsagePatternModel create(
            @RequestBody UsagePatternModel model,
            @PathVariable Long binId) {
        return service.createModel(model, binId);
    }

    @GetMapping
    public List<UsagePatternModel> getAll() {
        return service.getAllModels();
    }

    @GetMapping("/{id}")
    public UsagePatternModel getById(@PathVariable Long id) {
        return service.getModelById(id);
    }
}
