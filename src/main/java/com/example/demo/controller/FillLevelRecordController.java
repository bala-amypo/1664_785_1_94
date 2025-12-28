package com.example.demo.controller;

import com.example.demo.model.FillLevelRecord;
import com.example.demo.service.FillLevelRecordService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fill-level-records")
public class FillLevelRecordController {

    private final FillLevelRecordService fillLevelRecordService;

    public FillLevelRecordController(
            FillLevelRecordService fillLevelRecordService) {
        this.fillLevelRecordService = fillLevelRecordService;
    }

    // CREATE FILL LEVEL RECORD FOR A BIN
    @PostMapping("/{binId}")
    public FillLevelRecord createRecord(
            @RequestBody FillLevelRecord record,
            @PathVariable Long binId) {

        return fillLevelRecordService.createRecord(record, binId);
    }
}
