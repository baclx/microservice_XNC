package com.example.identity_card_service.service;

import com.example.identity_card_service.entity.Identitycard;
import com.example.identity_card_service.repository.IdentityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdentityServiceImpl implements IdentityService{
    @Autowired
    IdentityRepository identityRepository;

    @Override
    public List<Identitycard> getAllIdentityCards(){
        return identityRepository.findAll();
    }

    @Override
    public Identitycard findById(Long id){
        return  identityRepository.findById(id).get();
    }

    @Override
    public Identitycard addIdentityCard(Identitycard identitycard){
        return identityRepository.save(identitycard);
    }

    @Override
    public void deleteById(Long id) {
        identityRepository.deleteById(id);
    }


    @Override
    public Identitycard updateIdentityCard(Identitycard identitycard, Long id){
        identitycard.setId(id);
        return identityRepository.save(identitycard);
    }
}
