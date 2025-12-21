package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/fill-records")

public class FillLevelRecordController {

    private final FillLevelRecordService FillLevelRecordService;

    public FillLevelRecordController(FillLevelRecordService FillLevelRecordService) {
        this.FillLevelRecordService = FillLevelRecordService;
    }

    @PostMapping
    public FillRecord createRecord(@RequestBody FillRecordService record) {
        return FillLevelRecordService.createRecord(record);
    }

    @GetMapping("/{id}")
    public FillRecord getRecord(@PathVariable Long id) {
        return FillLevelRecordService.getRecordById(id);
    }

    @GetMapping("/bin/{binId}")
    public List<FillLevelRecord> getRecordsForBin(@PathVariable Long binId) {
        return FillLevelRecordService.getRecordsForBin(binId);
    }

    @GetMapping("/bin/{binId}/recent")
    public List<FillLevelRecord> getRecentRecords(
            @PathVariable Long binId,
            @RequestParam int limit
    ) {
        return fillLevelRecordService.getRecentRecords(binId, limit);
    }
}
