package com.example.demo.controller;

import com.example.demo.model.FillLevelRecord;
import com.example.demo.service.impl.FillLevelRecordServiceImpl;
import com.example.demo.service.UserService;

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
import java.util.List;

@RestController
@RequestMapping("/api/fill-records")
public class FillLevelRecordController {

    private final FillLevelRecordServiceImpl recordService;

    public FillLevelRecordController(FillLevelRecordServiceImpl recordService) {
        this.recordService = recordService;
    }

   @PostMapping("/bin/{binId}")
public ResponseEntity<FillLevelRecord> createRecord(
        @PathVariable Long binId,
        @RequestBody FillLevelRecord record) {
    return ResponseEntity.ok(
            recordService.createRecord(record, binId)
    );
}


    @GetMapping("/{id}")
    public FillLevelRecord getRecordById(@PathVariable Long id) {
        return recordService.getRecordById(id);
    }

    @GetMapping("/bin/{binId}")
    public List<FillLevelRecord> getRecentRecords(
            @PathVariable Long binId,
            @RequestParam(defaultValue = "5") int limit) {
        return recordService.getRecentRecords(binId, limit);
    }
}
