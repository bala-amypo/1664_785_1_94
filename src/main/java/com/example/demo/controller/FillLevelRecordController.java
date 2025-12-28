package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.FillLevelRecord;
import com.example.demo.service.FillLevelRecordService;

@RestController
@RequestMapping("/api/fill-levels")
public class FillLevelRecordController {

    private final FillLevelRecordService service;

    public FillLevelRecordController(FillLevelRecordService service) {
        this.service = service;
    }

    @PostMapping("/{binId}")
    public FillLevelRecord create(
            @RequestBody FillLevelRecord record,
            @PathVariable Long binId) {
        return service.createRecord(record, binId);
    }

    @GetMapping
    public List<FillLevelRecord> getAll() {
        return service.getAllRecords();
    }

    @GetMapping("/{id}")
    public FillLevelRecord getById(@PathVariable Long id) {
        return service.getRecordById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteRecord(id);
    }
}
