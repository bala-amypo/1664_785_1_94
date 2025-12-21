package com.example.demo.model;


@Entity
public class FillLevelRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Bin bin;

    private Double fillPercentage;

    private Timestamp recordedAt;

    private Boolean isWeekend;
}
