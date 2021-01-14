package com.turbo.turbochargerswebservices.controller;

import com.turbo.turbochargerswebservices.model.entity.Part;
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
    public List<Part> listAllParts() {
      return partService.findAll();
    }

    @GetMapping("/parts/{id}")
    public ResponseEntity<Part> getPartById(@PathVariable Long id) {
        Part part = partService.findById(id);
        return new ResponseEntity<>(part, HttpStatus.OK);
    }

    @PutMapping("/parts/{id}")
    public ResponseEntity<Part> updatePartById(@RequestBody Part part) {
        Part updatedPart = partService.update(part);
        return new ResponseEntity<>(updatedPart, HttpStatus.OK);
    }

    @PostMapping("/parts")
    public ResponseEntity<Part> createPart(@RequestBody Part part) {
        Part createdPart = partService.save(part);
        return new ResponseEntity<>(createdPart, HttpStatus.CREATED);
    }

    @DeleteMapping("/parts/{id}")
    public ResponseEntity<Part> deletePart(@PathVariable Long id) {
        partService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}


