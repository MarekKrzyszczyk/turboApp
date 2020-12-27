package com.turbo.turbochargerswebservices.controller;

import com.turbo.turbochargerswebservices.model.entity.Turbocharger;
import com.turbo.turbochargerswebservices.service.TurbochargerService;
import com.turbo.turbochargerswebservices.service.TurbochargerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TurbochargerController {

    private final TurbochargerService turbochargerService;

    @Autowired
    public TurbochargerController(TurbochargerServiceImpl turbochargerService) {
        this.turbochargerService = turbochargerService;
    }

    @GetMapping("/turbos")
    public List<Turbocharger> listAllTurbos() {
        return turbochargerService.findAll();
    }

    @GetMapping("/turbos/{id}")
    public ResponseEntity<Turbocharger> getTurboById(@PathVariable Long id) {
        Turbocharger turbo = turbochargerService.findById(id);
        return new ResponseEntity<>(turbo, HttpStatus.OK);
    }

    @PutMapping("/turbos/{id}")
    public ResponseEntity<Turbocharger> updateTurboById(@PathVariable Long id, @RequestBody Turbocharger turbocharger) {
        Turbocharger updatedTurbo = turbochargerService.update(turbocharger);
        return new ResponseEntity<>(updatedTurbo, HttpStatus.OK);
    }

    @PostMapping("/turbos")
    public ResponseEntity<Turbocharger> createTurbo(@RequestBody Turbocharger turbocharger) {
        return turbochargerService.create(turbocharger);
    }

    @DeleteMapping("/turbos/{id}")
    public ResponseEntity<Turbocharger> deleteTurbo(@PathVariable Long id) {
        turbochargerService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}


