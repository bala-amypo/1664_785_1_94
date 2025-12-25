package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Bin;
import com.example.demo.model.Zone;
import java.util.Optional;
import java.util.List;
public interface BinRepository  extends JpaRepository<Bin,Long> {
    Optional<Bin> findByIdentifier(String identifier);
    List<Bin> findByZoneAndActiveTrue(Zone zone);
}
