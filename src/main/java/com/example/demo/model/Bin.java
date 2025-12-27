// package com.example.demo.model;

// import jakarta.persistence.*;

// @Entity
// public class Bin {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String name;
//     private int capacity;
//     private boolean active = true;

//     public Bin() {}

//     public Long getId() { return id; }
//     public String getName() { return name; }
//     public void setName(String name) { this.name = name; }
//     public int getCapacity() { return capacity; }
//     public void setCapacity(int capacity) { this.capacity = capacity; }
//     public boolean isActive() { return active; }
//     public void setActive(boolean active) { this.active = active; }
// }
package com.example.demo.model;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class Bin {
    private Long id;
    private String location;
    private Double capacity;
    private Double currentFillLevel;
    private Double fillRatePerDay;
    private Zone zone;
    private List<FillLevelRecord> fillLevelRecords = new ArrayList<>();
    private List<UsagePatternModel> usagePatternModels = new ArrayList<>();
    private List<OverflowPrediction> overflowPredictions = new ArrayList<>();
}