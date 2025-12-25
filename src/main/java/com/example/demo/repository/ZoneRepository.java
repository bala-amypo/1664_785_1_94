package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Zone;
import java.util.Optional;

public interface ZoneRepository  extends JpaRepository<Zone,Long> {
    Optional<Zone> findByZoneName(String name);
    
}
