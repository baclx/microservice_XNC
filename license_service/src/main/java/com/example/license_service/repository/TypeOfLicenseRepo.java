package com.example.license_service.repository;

import com.example.license_service.entity.TypeOfLicense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfLicenseRepo extends JpaRepository<TypeOfLicense, Long> {

    TypeOfLicense findTypeOfLicenseByName(String name);

    TypeOfLicense findTypeOfLicenseById(Long id);

}
