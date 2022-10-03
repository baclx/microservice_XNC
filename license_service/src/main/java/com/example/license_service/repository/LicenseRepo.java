package com.example.license_service.repository;

import com.example.license_service.entity.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenseRepo extends JpaRepository<License, Long> {

    License findLicenseById(Long id);

}
