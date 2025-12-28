package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.FillLevelRecord;

public interface FillLevelRecordRepository
        extends JpaRepository<FillLevelRecord, Long> {
}
