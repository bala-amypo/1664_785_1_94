package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/fill-records")
@Tag(name = "Fill Level Records")
public class FillLevelRecordController {

    private final FillLevelRecordService fillLevelRecordService;

    public FillLevelRecordController(FillLevelRecordService fillLevelRecordService) {
        this.fillLevelRecordService = fillLevelRecordService;
    }

    @PostMapping
    public FillRecord createRecord(@RequestBody FillRecord record) {
        return fillLevelRecordService.createRecord(record);
    }

    @GetMapping("/{id}")
    public FillRecord getRecord(@PathVariable Long id) {
        return fillLevelRecordService.getRecordById(id);
    }

    @GetMapping("/bin/{binId}")
    public List<FillRecord> getRecordsForBin(@PathVariable Long binId) {
        return fillLevelRecordService.getRecordsForBin(binId);
    }

    @GetMapping("/bin/{binId}/recent")
    public List<FillRecord> getRecentRecords(
            @PathVariable Long binId,
            @RequestParam int limit
    ) {
        return fillLevelRecordService.getRecentRecords(binId, limit);
    }
}
