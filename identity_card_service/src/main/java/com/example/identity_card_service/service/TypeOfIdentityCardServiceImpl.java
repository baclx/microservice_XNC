package com.example.identity_card_service.service;

import com.example.identity_card_service.entity.TypeOfIdentitycard;
import com.example.identity_card_service.repository.TypeOfIdentityCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeOfIdentityCardServiceImpl implements  TypeOfIdentityCardSerVice{
    @Autowired
    TypeOfIdentityCardRepository typeOfIdentityCardRepository;

    public TypeOfIdentitycard addTypeofIdentityCard(TypeOfIdentitycard type){
        return typeOfIdentityCardRepository.save(type);
    }
}
