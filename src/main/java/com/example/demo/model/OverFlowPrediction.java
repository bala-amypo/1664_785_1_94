package com.example.demo.model;


@Entity
public class OverFlowPrediction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Bin bin;

    private LocalDate predictedFullDate;
    private Integer daysUntilFull;

    @ManyToOne
    private UsagePatternModel modelUsed;

    private Timestamp generatedAt;
}
