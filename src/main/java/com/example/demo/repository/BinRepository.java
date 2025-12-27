// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo.model.Bin;
// import com.example.demo.model.Zone;
// import java.util.Optional;
// import java.util.List;
// public interface BinRepository  extends JpaRepository<Bin,Long> {
// Optional<Bin> findByIdentifier(String identifier);
// List<Bin> findByZoneAndActiveTrue(Zone zone);
// }
package com.example.demo.repository;

import com.example.demo.model.Bin;
import java.util.List;
import java.util.Optional;

public interface BinRepository {
    Bin save(Bin bin);
    List<Bin> findAll();
    Optional<Bin> findById(Long id);
    void deleteById(Long id);
    List<Bin> findByCurrentFillLevelGreaterThanEqual(Double fillLevel);
}