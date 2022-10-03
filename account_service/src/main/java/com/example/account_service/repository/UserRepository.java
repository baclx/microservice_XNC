package com.example.account_service.repository;

import com.example.account_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
//    @Query(value = "SELECT id FROM Users ORDER BY id DESC LIMIT 1;", nativeQuery = true)
//    Long selectLastId();
}