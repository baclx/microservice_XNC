package com.example.identity_card_service.repository;

import com.example.identity_card_service.entity.Identitycard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentityRepository extends JpaRepository<Identitycard,Long> {
}
