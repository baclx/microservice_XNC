package com.example.license_service.service;

import com.example.license_service.entity.ResponseObject;
import com.example.license_service.entity.TypeOfLicense;
import com.example.license_service.repository.TypeOfLicenseRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TypeOfLicenseServicesImpl implements TypeOfLicenseServices {
    private final TypeOfLicenseRepo typeOfLicenseRepo;

    @Override
    public ResponseEntity<ResponseObject> getAllTypeOfLicense() {
        return ResponseEntity.ok(new ResponseObject("OK", "Successfully", typeOfLicenseRepo.findAll()));
    }

    @Override
    public ResponseEntity<ResponseObject> saveNewTypeOfLicense(TypeOfLicense typeOfLicense) {
        TypeOfLicense exists = typeOfLicenseRepo.findTypeOfLicenseByName(typeOfLicense.getName());
        if (exists != null) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(new ResponseObject("FALSE", "This name already existing", null));
        }
        typeOfLicenseRepo.save(typeOfLicense);
        return ResponseEntity.ok(new ResponseObject("OK", "Successfully", typeOfLicense));
    }

    @Override
    public ResponseEntity<ResponseObject> deleteTypeOfLicenseById(Long id) {
        TypeOfLicense typeOfLicense = typeOfLicenseRepo.findTypeOfLicenseById(id);
        if (typeOfLicense == null) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(new ResponseObject("FALSE", "This name is not existing", null));
        }
        typeOfLicenseRepo.deleteById(id);
        return ResponseEntity.ok(new ResponseObject("OK", "Successfully", id));
    }

    @Override
    public ResponseEntity<ResponseObject> updateTypeOfLicenseById(Long id, TypeOfLicense typeOfLicense) {
        TypeOfLicense typeOfLicenseUpdate = typeOfLicenseRepo.findTypeOfLicenseById(id);
        if (typeOfLicenseUpdate == null) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(new ResponseObject("FALSE", "This name is not existing", null));
        }
        typeOfLicenseUpdate.setName(typeOfLicense.getName());
        typeOfLicenseRepo.save(typeOfLicenseUpdate);
        return ResponseEntity.ok(new ResponseObject("OK", "Successfully", typeOfLicenseUpdate));
    }
}
