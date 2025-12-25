package com.example.demo.controller;

import com.example.demo.model.UsagePatternModel;
import com.example.demo.service.impl.UsagePatternModelServiceImpl;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.service.UsagePatternModelService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usage-patterns")
public class UsagePatternModelController {

    private final UsagePatternModelService modelService;

    public UsagePatternModelController(UsagePatternModelService modelService) {
        this.modelService = modelService;
    }

    @PostMapping
    public ResponseEntity<UsagePatternModel> create(
            @RequestBody UsagePatternModel model) {
        return ResponseEntity.ok(
                modelService.createModel(model)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsagePatternModel> update(
            @PathVariable Long id,
            @RequestBody UsagePatternModel model) {
        return ResponseEntity.ok(
                modelService.updateModel(id, model)
        );
    }

    @GetMapping("/bin/{binId}")
    public ResponseEntity<UsagePatternModel> getForBin(
            @PathVariable Long binId) {
        return ResponseEntity.ok(
                modelService.getLatestModelForBin(binId)
        );
    }
}
