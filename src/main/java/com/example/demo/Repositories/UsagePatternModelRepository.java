public interface UsagePatternModelRepository extends JpaRepository<UsagePatternModel, Long> {
    Optional<UsagePatternModel> findByBin(Bin bin);
}
