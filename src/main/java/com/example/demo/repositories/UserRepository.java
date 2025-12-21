package com.example.demo.repositories;



public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String Email);
}
