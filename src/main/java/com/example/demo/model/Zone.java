package com.example.demo.model;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class Zone {
    private Long id;
    private String zoneName;
    private List<Bin> bins = new ArrayList<>();
}