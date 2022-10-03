package com.example.immigration_info_service.controller;

import com.example.immigration_info_service.model.Purpose;
import com.example.immigration_info_service.service.PurposeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purposes")
@CrossOrigin(value = "*", maxAge = 3600)

public class PurposeController {
    @Autowired
    PurposeServiceImpl purposeService;

    @GetMapping("get-all")
    public ResponseEntity<List<Purpose>> getAllPurpose(){
        List<Purpose> purpose = purposeService.getAllPurpose();
        return new ResponseEntity<>(purpose, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Purpose> addPurpose(@Valid @RequestBody Purpose purpose){
        return ResponseEntity.ok(purposeService.savePurpose(purpose));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Purpose> update(@Valid @PathVariable("id") Long id,
                                            @RequestBody Purpose newPurpose) {
        Optional<Purpose> purpose = purposeService.getPurposeById(id);
        if (purpose.isPresent()) {
            purpose.get().setName(newPurpose.getName());
            purpose.get().setDescription(newPurpose.getDescription());
            purposeService.savePurpose(purpose.get());
            return ResponseEntity.ok(purpose.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("delete/{id}")
    public Object deletePurpose(@PathVariable("id")Long id){
        if(purposeService.getPurposeById(id).isPresent()){
            purposeService.deletePurposeById(id);
            return ResponseEntity.ok("Deleted purpose with id = "+id);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
