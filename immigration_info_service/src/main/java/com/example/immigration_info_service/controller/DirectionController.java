package com.example.immigration_info_service.controller;

import com.example.immigration_info_service.model.Direction;
import com.example.immigration_info_service.service.DirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/direction")
@CrossOrigin(value = "*", maxAge = 3600)

public class DirectionController {
    @Autowired
    DirectionService directionService;

    @GetMapping("/get-all")
    public ResponseEntity<List<Direction>> getAll() {
        List<Direction> directionLists = directionService.findAll();

        return new ResponseEntity<>(directionLists, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Direction> save(@Valid @RequestBody Direction direction) {
        try {
            directionService.save(direction);
            return ResponseEntity.ok(direction);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Direction> update(@Valid @PathVariable("id") Long id,
                                            @RequestBody Direction newDirection
    ) {
        Optional<Direction> direction = directionService.findById(id);
        if (direction.isPresent()) {
            direction.get().setName(newDirection.getName());
            direction.get().setImmigrationInformationById(newDirection.getImmigrationInformationById());
            directionService.save(direction.get());
            return ResponseEntity.ok(direction.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("delete/{id}")
    public Object delete(
            @PathVariable("id") Long id
    ) {
        if (directionService.findById(id).isPresent()) {
            directionService.deleteById(id);
            return ResponseEntity.ok("Deleted direction with id = " + id);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
