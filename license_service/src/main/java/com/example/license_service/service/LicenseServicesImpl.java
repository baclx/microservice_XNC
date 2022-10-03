package com.example.license_service.service;

import com.example.license_service.entity.License;
import com.example.license_service.entity.ResponseObject;
import com.example.license_service.entity.TypeOfLicense;
import com.example.license_service.form.AddTypeForLicenseForm;
import com.example.license_service.repository.LicenseRepo;
import com.example.license_service.repository.TypeOfLicenseRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LicenseServicesImpl implements LicenseServices {
    private final LicenseRepo licenseRepo;
    private final TypeOfLicenseRepo typeOfLicenseRepo;

    @Override
    public ResponseEntity<ResponseObject> getAllLicense() {
        return ResponseEntity.ok(new ResponseObject("OK", "Successfully", licenseRepo.findAll()));
    }

    @Override
    public ResponseEntity<ResponseObject> saveNewLicense(License license) {
        licenseRepo.save(license);
        return ResponseEntity.ok(new ResponseObject("OK", "Successfully", license));
    }

    @Override
    public ResponseEntity<ResponseObject> deleteLicenseById(Long id) {
        License license = licenseRepo.findLicenseById(id);
        if (license != null) {
            licenseRepo.deleteById(id);
            return ResponseEntity.ok(new ResponseObject("OK", "Successfully", id));
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(new ResponseObject("FALSE", "This license is not exists !", null));
    }

    @Override
    public ResponseEntity<ResponseObject> updateLicenseById(Long id, License license) {
        License licenseUpdate = licenseRepo.findLicenseById(id);
        if (licenseUpdate != null) {
            licenseUpdate.setLicenseNumber(license.getLicenseNumber());
            licenseUpdate.setIssuedOn(license.getIssuedOn());
            licenseUpdate.setDateOfExpiry(license.getDateOfExpiry());
            licenseUpdate.setPlaceOfIssue(license.getPlaceOfIssue());
//            licenseUpdate.setTypeOfLicense(license.getTypeOfLicense());
            licenseRepo.save(licenseUpdate);
            return ResponseEntity.ok(new ResponseObject("OK", "Successfully", licenseUpdate));
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(new ResponseObject("FALSE", "This license is not exists !", null));
    }

    @Override
    public ResponseEntity<ResponseObject> addTypeForLicenseById(Long id, AddTypeForLicenseForm form) {
        License license = licenseRepo.findLicenseById(id);
        TypeOfLicense typeOfLicense = typeOfLicenseRepo.findTypeOfLicenseByName(form.getTypeName());
        if (license == null || typeOfLicense == null) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(new ResponseObject("FALSE", "Not exists !", null));
        }
        typeOfLicense.addLicense(license);
        typeOfLicenseRepo.save(typeOfLicense);
        return ResponseEntity.ok(new ResponseObject("OK", "Successfully", license));

    }
}
