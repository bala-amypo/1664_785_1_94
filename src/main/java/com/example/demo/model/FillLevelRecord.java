package com.example.demo.model;

import jakarta.persistence.Entity;
import jarkarta.persistence.Id;
import jarkarta.persistence.Gener


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
