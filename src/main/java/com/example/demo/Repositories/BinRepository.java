public interface BinRepository extends JpaRepository<Bin, Long> {
    Optional<Bin> findByIdentifier(String identifier);
    List<Bin> findByZoneAndActiveTrue(Zone zone);
}
