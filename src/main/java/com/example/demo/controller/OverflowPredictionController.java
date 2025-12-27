// package com.example.demo.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import com.example.demo.model.OverflowPrediction;
// import com.example.demo.service.OverflowPredictionService;

// @RestController
// @RequestMapping("/api/predictions")
// public class OverflowPredictionController {

//     @Autowired
//     private OverflowPredictionService predictionService;

//     @PostMapping("/generate/{binId}")
//     public OverflowPrediction generatePrediction(@PathVariable Long binId) {
//         return predictionService.generatePrediction(binId);
//     }
// }
package com.example.demo.controller;

import com.example.demo.model.OverflowPrediction;
import com.example.demo.service.OverflowPredictionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/predictions")
public class OverflowPredictionController {

    private final OverflowPredictionService predictionService;

    // ✅ Constructor injection (BEST practice)
    public OverflowPredictionController(OverflowPredictionService predictionService) {
        this.predictionService = predictionService;
    }

    @PostMapping
    public OverflowPrediction create(@RequestBody OverflowPrediction prediction) {
        return predictionService.savePrediction(prediction);
    }

    @GetMapping
    public List<OverflowPrediction> getAll() {
        return predictionService.getAllPredictions();
    }
}
