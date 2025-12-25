package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Bin;
import java.util.Optional;
import java.util.
public interface BinRepository {
    Optional<Bin> findById(Long id);
    Optional<Bin> findByIdentifier(String identifier);
    List<Bin> findAll();
    List<Bin> findByZoneAndActiveTrue(Zone zone);
    Bin save(Bin bin);
}
