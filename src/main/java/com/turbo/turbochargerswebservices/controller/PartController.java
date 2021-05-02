package com.turbo.turbochargerswebservices.controller;

import com.turbo.turbochargerswebservices.model.dto.part.PartDto;
import com.turbo.turbochargerswebservices.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PartController {

    private final PartService partService;

    @Autowired
    public PartController(PartService partService) {
        this.partService = partService;
    }

    @GetMapping("/parts")
    public ResponseEntity<List<PartDto>> listAllParts() {
        List<PartDto> parts = partService.findAll();
        return new ResponseEntity<>(parts, HttpStatus.OK);
    }

    @GetMapping("/parts/{id}")
    public ResponseEntity<PartDto> getPartById(@PathVariable Long id) {
        PartDto part = partService.findById(id);
        return new ResponseEntity<>(part, HttpStatus.OK);
    }

    @PostMapping("/parts")
    public ResponseEntity<PartDto> createPart(@RequestBody PartDto part) {
        PartDto createdPart = partService.save(part);
        return new ResponseEntity<>(createdPart, HttpStatus.CREATED);
    }

    @PutMapping("/parts/{id}")
    public ResponseEntity<PartDto> updatePartById(@RequestBody PartDto part) {
        PartDto updatedPart = partService.save(part);
        return new ResponseEntity<>(updatedPart, HttpStatus.OK);
    }

    @DeleteMapping("/parts/{id}")
    public ResponseEntity<PartDto> deletePart(@PathVariable Long id) {
        partService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}


