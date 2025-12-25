package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Bin;
import com.example.demo.model.Zone;
import java.util.Optional;
import java.util.List;
public interface BinRepository {
    Optional<Bin> findById(Long id);
    Optional<Bin> findByIdentifier(String identifier);
    List<Bin> findAll();
    List<Bin> findByZoneAndActiveTrue(Zone zone);
    Bin save(Bin bin);
}
