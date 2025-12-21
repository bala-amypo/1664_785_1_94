package com.example

@Entity
public class UsagePatternModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Bin bin;

    private Double avgDailyIncreaseWeekday;
    private Double avgDailyIncreaseWeekend;

    private Timestamp lastUpdated;
}
