package com.example.license_service.service;

import com.example.license_service.entity.ResponseObject;
import com.example.license_service.entity.TypeOfLicense;
import org.springframework.http.ResponseEntity;

public interface TypeOfLicenseServices {

    ResponseEntity<ResponseObject> getAllTypeOfLicense();

    ResponseEntity<ResponseObject> saveNewTypeOfLicense(TypeOfLicense typeOfLicense);

    ResponseEntity<ResponseObject> deleteTypeOfLicenseById(Long id);

    ResponseEntity<ResponseObject> updateTypeOfLicenseById(Long id, TypeOfLicense typeOfLicense);

}
