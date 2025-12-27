// package com.example.demo.service.impl;

// import com.example.demo.model.Zone;
// import com.example.demo.model.OverflowPrediction;
// import com.example.demo.repository.BinRepository;
// import com.example.demo.repository.FillLevelRecordRepository;
// import com.example.demo.repository.UsagePatternModelRepository;
// import com.example.demo.repository.OverflowPredictionRepository;
// import com.example.demo.repository.ZoneRepository;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class OverflowPredictionServiceImpl {

//     private final BinRepository binRepository;
//     private final FillLevelRecordRepository recordRepository;
//     private final UsagePatternModelRepository modelRepository;
//     private final OverflowPredictionRepository predictionRepository;
//     private final ZoneRepository zoneRepository;

//     public OverflowPredictionServiceImpl(
//             BinRepository binRepository,
//             FillLevelRecordRepository recordRepository,
//             UsagePatternModelRepository modelRepository,
//             OverflowPredictionRepository predictionRepository,
//             ZoneRepository zoneRepository) {

//         this.binRepository = binRepository;
//         this.recordRepository = recordRepository;
//         this.modelRepository = modelRepository;
//         this.predictionRepository = predictionRepository;
//         this.zoneRepository = zoneRepository;
//     }

//     public List<OverflowPrediction> getLatestPredictionsForZone(long zoneId) {
//         Zone zone = zoneRepository.findById(zoneId)
//                 .orElseThrow(() -> new RuntimeException("Zone not found"));
//         return predictionRepository.findLatestPredictionsForZone(zone);
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.model.OverflowPrediction;
import com.example.demo.repository.OverflowPredictionRepository;
import com.example.demo.service.OverflowPredictionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   // 🔴 THIS annotation is what was missing
public class OverflowPredictionServiceImpl implements OverflowPredictionService {

    private final OverflowPredictionRepository repository;

    public OverflowPredictionServiceImpl(OverflowPredictionRepository repository) {
        this.repository = repository;
    }

    @Override
    public OverflowPrediction savePrediction(OverflowPrediction prediction) {
        return repository.save(prediction);
    }

    @Override
    public List<OverflowPrediction> getAllPredictions() {
        return repository.findAll();
    }
}
