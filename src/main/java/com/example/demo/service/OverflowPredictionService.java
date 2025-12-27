// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.model.OverflowPrediction;

// public interface OverflowPredictionService {

//     OverflowPrediction getPredictionById(Long id);

//     List<OverflowPrediction> getPredictionsForBin(Long binId);

//     List<OverflowPrediction> getLatestPredictionsByZone(Long zoneId);

//     OverflowPrediction generatePrediction(Long binId);
// }
package com.example.demo.service;

import com.example.demo.model.OverflowPrediction;
import java.util.List;

public interface OverflowPredictionService {

    OverflowPrediction savePrediction(OverflowPrediction prediction);

    List<OverflowPrediction> getAllPredictions();
}
