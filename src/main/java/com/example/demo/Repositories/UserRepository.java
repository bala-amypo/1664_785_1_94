public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String UserName);
}
