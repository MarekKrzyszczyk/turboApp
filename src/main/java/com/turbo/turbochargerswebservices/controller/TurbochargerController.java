package com.turbo.turbochargerswebservices.controller;

import com.turbo.turbochargerswebservices.model.Turbocharger;
import com.turbo.turbochargerswebservices.service.TurbochargerService;
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
    public TurbochargerController(TurbochargerService turbochargerService) {
        this.turbochargerService = turbochargerService;
    }

    @GetMapping("/turbos")
    public List<Turbocharger> listAllTurbos() {
      return turbochargerService.getAllTurbos();
    }

    @GetMapping("/turbos/{id}")
    public ResponseEntity<Turbocharger> getTurboById(@PathVariable Long id) {
        Turbocharger turbo = turbochargerService.findTurboById(id);
        return new ResponseEntity<>(turbo, HttpStatus.OK);
    }

    @PostMapping("/turbos")
    public ResponseEntity<Turbocharger> createTurbo(@RequestBody Turbocharger turbocharger) {
        Turbocharger createdTurbocharger = turbochargerService.addTurbo(turbocharger);
        return new ResponseEntity<>(createdTurbocharger, HttpStatus.CREATED);
    }

    @DeleteMapping("/turbos/{id}")
    public ResponseEntity<Turbocharger> deleteTurbo(@PathVariable Long id) {
        turbochargerService.deleteTurbo(id);
        return ResponseEntity.ok().build();
    }
}


