package com.turbo.turbochargerswebservices.controller;

import com.turbo.turbochargerswebservices.model.dto.turbocharger.TurbochargerDto;
import com.turbo.turbochargerswebservices.service.TurbochargerService;
import com.turbo.turbochargerswebservices.service.TurbochargerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TurbochargerController {

    private final TurbochargerService turbochargerService;

    @Autowired
    public TurbochargerController(TurbochargerServiceImpl turbochargerService) {
        this.turbochargerService = turbochargerService;
    }

    @GetMapping("/turbos")
    public ResponseEntity<List<TurbochargerDto>> listAllTurbos() {
        List<TurbochargerDto> turbochargers = turbochargerService.findAll();
        return new ResponseEntity<>(turbochargers, HttpStatus.OK);
    }

    @GetMapping("/turbos/{id}")
    public ResponseEntity<TurbochargerDto> getTurboById(@PathVariable Long id) {
        TurbochargerDto turbocharger = turbochargerService.findById(id);
        return new ResponseEntity<>(turbocharger, HttpStatus.OK);
    }

    @PostMapping("/turbos")
    public ResponseEntity<TurbochargerDto> createTurbo(@RequestBody TurbochargerDto turbocharger) {
        TurbochargerDto createdTurbocharger = turbochargerService.create(turbocharger);
        return new ResponseEntity<>(createdTurbocharger, HttpStatus.CREATED);
    }

    @PutMapping("/turbos/{id}")
    public ResponseEntity<TurbochargerDto> updateTurboById(@PathVariable Long id) {
        TurbochargerDto updatedTurbo = turbochargerService.updateById(id);
        return new ResponseEntity<>(updatedTurbo, HttpStatus.OK);
    }

    @DeleteMapping("/turbos/{id}")
    public ResponseEntity<TurbochargerDto> deleteTurbo(@PathVariable Long id) {
        turbochargerService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}