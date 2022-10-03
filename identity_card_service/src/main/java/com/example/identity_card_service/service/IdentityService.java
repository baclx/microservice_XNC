package com.example.identity_card_service.service;

import com.example.identity_card_service.entity.Identitycard;

import java.util.List;

public interface IdentityService {
    List<Identitycard> getAllIdentityCards();

    Identitycard findById(Long id);

    Identitycard addIdentityCard(Identitycard identitycard);

    void deleteById(Long id);

    Identitycard updateIdentityCard(Identitycard identitycard, Long id);
}
