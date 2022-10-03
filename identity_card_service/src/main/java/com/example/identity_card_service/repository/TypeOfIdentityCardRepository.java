package com.example.identity_card_service.repository;

import com.example.identity_card_service.entity.TypeOfIdentitycard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface TypeOfIdentityCardRepository extends JpaRepository<TypeOfIdentitycard,Long> {
}
