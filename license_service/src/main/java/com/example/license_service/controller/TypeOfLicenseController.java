package com.example.license_service.controller;

import com.example.license_service.entity.ResponseObject;
import com.example.license_service.entity.TypeOfLicense;
import com.example.license_service.service.TypeOfLicenseServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/type-of-license")
public class TypeOfLicenseController {

    private final TypeOfLicenseServices typeOfLicenseServices;

    @GetMapping
    public ResponseEntity<ResponseObject> getAllTypeOfLicense() {
        return typeOfLicenseServices.getAllTypeOfLicense();
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseObject> saveNewTypeOfLicense(@RequestBody TypeOfLicense typeOfLicense) {
        return typeOfLicenseServices.saveNewTypeOfLicense(typeOfLicense);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseObject> deleteTypeOfLicenseById(@PathVariable Long id) {
        return typeOfLicenseServices.deleteTypeOfLicenseById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseObject> updateTypeOfLicenseById(@PathVariable Long id, @RequestBody TypeOfLicense typeOfLicense) {
        return typeOfLicenseServices.updateTypeOfLicenseById(id, typeOfLicense);
    }

}
