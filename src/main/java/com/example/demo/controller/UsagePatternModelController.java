package com.example.demo.controller;

import com.example.demo.model.UsagePatternModel;
import com.example.demo.service.UsagePatternModelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usage-patterns")
public class UsagePatternModelController {

    private final UsagePatternModelService modelService;

    public UsagePatternModelController(UsagePatternModelService modelService) {
        this.modelService = modelService;
    }

    @PostMapping("/bin/{binId}")
    public ResponseEntity<UsagePatternModel> createModel(
            @PathVariable Long binId,
            @RequestBody UsagePatternModel model) {

        return ResponseEntity.ok(
                modelService.createModel(model, binId)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsagePatternModel> updateModel(
            @PathVariable Long id,
            @RequestBody UsagePatternModel model) {

        return ResponseEntity.ok(
                modelService.updateModel(id, model)
        );
    }

    @GetMapping("/bin/{binId}")
    public ResponseEntity<UsagePatternModel> getModelForBin(
            @PathVariable Long binId) {

        return ResponseEntity.ok(
                modelService.getModelForBin(binId)
        );
    }
}
