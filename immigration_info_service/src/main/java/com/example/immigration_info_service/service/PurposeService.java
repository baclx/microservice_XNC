package com.example.immigration_info_service.service;

import com.example.immigration_info_service.model.Purpose;

import java.util.List;
import java.util.Optional;

public interface PurposeService {
    Purpose savePurpose(Purpose purpose);

    void deletePurposeById(Long id);
    Optional<Purpose> getPurposeById(Long id);
    List<Purpose> getAllPurpose();

}