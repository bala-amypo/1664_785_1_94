package com.example.demo.repositories;



public interface ZoneRepository extends JpaRepository<Zone, Long> {
    Optional<Zone> findByZoneName(String zoneName);
}
