package com.example.demo.controller;

import com.example.demo.model.UsagePatternModel;
import com.example.demo.service.UsagePatternModelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usage-pattern-models")
public class UsagePatternModelController {

    private final UsagePatternModelService usagePatternModelService;

    // ✅ Constructor Injection (MANDATORY for your test suite)
    public UsagePatternModelController(UsagePatternModelService usagePatternModelService) {
        this.usagePatternModelService = usagePatternModelService;
    }

    // ---------------- CREATE ----------------
    @PostMapping
    public ResponseEntity<UsagePatternModel> createModel(
            @RequestBody UsagePatternModel model) {

        UsagePatternModel savedModel =
                usagePatternModelService.createModel(model);

        return new ResponseEntity<>(savedModel, HttpStatus.CREATED);
    }

    // ---------------- UPDATE ----------------
    @PutMapping("/{id}")
    public ResponseEntity<UsagePatternModel> updateModel(
            @PathVariable Long id,
            @RequestBody UsagePatternModel model) {

        UsagePatternModel updatedModel =
                usagePatternModelService.updateModel(id, model);

        return ResponseEntity.ok(updatedModel);
    }

    // ---------------- GET MODEL FOR BIN ----------------
    @GetMapping("/bin/{binId}")
    public ResponseEntity<UsagePatternModel> getModelForBin(
            @PathVariable Long binId) {

        UsagePatternModel model =
                usagePatternModelService.getModelForBin(binId);

        return ResponseEntity.ok(model);
    }

    // ---------------- GET ALL MODELS ----------------
    @GetMapping
    public ResponseEntity<List<UsagePatternModel>> getAllModels() {
        return ResponseEntity.ok(
                usagePatternModelService.getAllModels()
        );
    }
}
