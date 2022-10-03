package com.example.license_service.service;

import com.example.license_service.entity.License;
import com.example.license_service.entity.ResponseObject;
import com.example.license_service.form.AddTypeForLicenseForm;
import org.springframework.http.ResponseEntity;

public interface LicenseServices {
    ResponseEntity<ResponseObject> getAllLicense();

    ResponseEntity<ResponseObject> saveNewLicense(License license);

    ResponseEntity<ResponseObject> deleteLicenseById(Long id);

    ResponseEntity<ResponseObject> updateLicenseById(Long id, License license);

    ResponseEntity<ResponseObject> addTypeForLicenseById(Long id, AddTypeForLicenseForm form);
}
