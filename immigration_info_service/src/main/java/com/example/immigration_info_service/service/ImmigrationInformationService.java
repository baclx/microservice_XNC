package com.example.immigration_info_service.service;

import com.example.immigration_info_service.model.ImmigrationInformation;

import java.util.List;
import java.util.Optional;

public interface ImmigrationInformationService {
    List<ImmigrationInformation> getAllImmigrationInformation();

    ImmigrationInformation saveImmigration(ImmigrationInformation immigration);

    void DeleteImmigrationById(Long id);

    Optional<ImmigrationInformation> getImmigrationById(Long id);

}
