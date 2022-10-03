package com.example.immigration_info_service.controller;

import com.example.immigration_info_service.model.ImmigrationInformation;
import com.example.immigration_info_service.service.ImmigrationInformationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("immigrationInformation-service")
@CrossOrigin(value = "*", maxAge = 3600)
public class ImmigrationInformationController {
    @Autowired
    ImmigrationInformationServiceImpl immigrationInformationService;

    @GetMapping("/get-all")
    public ResponseEntity<List<ImmigrationInformation>> getAll() {
        List<ImmigrationInformation> immigrationInformationList = immigrationInformationService.getAllImmigrationInformation();

        return new ResponseEntity<>(immigrationInformationList, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ImmigrationInformation> addImmigrationInformation(
            @Valid @RequestBody ImmigrationInformation immigration
    ){
        try {
            immigrationInformationService.saveImmigration(immigration);
            return ResponseEntity.ok(immigration);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ImmigrationInformation> updateImmigration(
            @PathVariable("id") Long id, @Valid @RequestBody ImmigrationInformation newImmigration){
        Optional<ImmigrationInformation> immigrationInformation = immigrationInformationService.getImmigrationById(id);
        if (immigrationInformation.isPresent()) {
            immigrationInformation.get().setDestination(newImmigration.getDestination());
            immigrationInformation.get().setReturnDate(newImmigration.getReturnDate());
            immigrationInformation.get().setStartDate(newImmigration.getStartDate());
            immigrationInformation.get().setPurposeById(newImmigration.getPurposeById());
            immigrationInformation.get().setDirectionId(newImmigration.getDirectionId());
            immigrationInformationService.saveImmigration(immigrationInformation.get());
            return ResponseEntity.ok(immigrationInformation.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public Object deleteImmigration(@PathVariable("id") Long id){
        if(immigrationInformationService.getImmigrationById(id).isPresent()){
            immigrationInformationService.DeleteImmigrationById(id);
            return ResponseEntity.ok("Deleted Immigration with id = "+id);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
