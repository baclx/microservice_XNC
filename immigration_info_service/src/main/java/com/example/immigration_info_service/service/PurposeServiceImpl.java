package com.example.immigration_info_service.service;

import com.example.immigration_info_service.model.Purpose;
import com.example.immigration_info_service.repository.PurposeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurposeServiceImpl implements PurposeService{
    @Autowired
    PurposeRepository purposeRepository;

    @Override
    public Purpose savePurpose(Purpose purpose) {
        return purposeRepository.save(purpose);
    }


    @Override
    public void deletePurposeById(Long id) {
        purposeRepository.deleteById(id);
    }

    @Override
    public Optional<Purpose> getPurposeById(Long id) {
        return purposeRepository.findById(id);
    }

    @Override
    public List<Purpose> getAllPurpose() {
        return purposeRepository.findAll();
    }


}