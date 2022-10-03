package com.example.license_service.controller;

import com.example.license_service.entity.License;
import com.example.license_service.entity.ResponseObject;
import com.example.license_service.form.AddTypeForLicenseForm;
import com.example.license_service.service.LicenseServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/license-service")
@AllArgsConstructor
public class LicenseController {
    private final LicenseServices licenseServices;

    @GetMapping
    public ResponseEntity<ResponseObject> getAllLicense() {
        return licenseServices.getAllLicense();
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseObject> saveNewLicense(@RequestBody License license) {
        return licenseServices.saveNewLicense(license);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseObject> deleteLicenseById(@PathVariable Long id) {
        return licenseServices.deleteLicenseById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseObject> UpdateLicenseById(@PathVariable Long id, @RequestBody License license) {
        return licenseServices.updateLicenseById(id, license);
    }

    @PostMapping("/{id}/add-type")
    public ResponseEntity<ResponseObject> addTypeForLicenseById(@PathVariable Long id, @RequestBody AddTypeForLicenseForm form) {
        return licenseServices.addTypeForLicenseById(id, form);
    }

}
