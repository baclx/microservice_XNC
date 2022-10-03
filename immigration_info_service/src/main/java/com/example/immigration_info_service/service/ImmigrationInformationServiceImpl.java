package com.example.immigration_info_service.service;

import com.example.immigration_info_service.model.ImmigrationInformation;
import com.example.immigration_info_service.repository.ImmigrationInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImmigrationInformationServiceImpl implements ImmigrationInformationService {
    @Autowired
    ImmigrationInformationRepository immigrationRepository;

    @Override
    public List<ImmigrationInformation> getAllImmigrationInformation() {
        return immigrationRepository.findAll();
    }

    @Override
    public ImmigrationInformation saveImmigration(ImmigrationInformation immigration) {
        return immigrationRepository.save(immigration);
    }

    @Override
    public void DeleteImmigrationById(Long id) {
        immigrationRepository.deleteById(id);
    }

    @Override
    public Optional<ImmigrationInformation> getImmigrationById(Long id) {
        return immigrationRepository.findById(id);
    }
}
