package com.turbo.turbochargerswebservices.controller;

import com.turbo.turbochargerswebservices.model.entity.Reason;
import com.turbo.turbochargerswebservices.service.ReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ReasonController {

    private final ReasonService reasonService;

    @Autowired
    public ReasonController(ReasonService reasonService) {
        this.reasonService = reasonService;
    }

    @GetMapping("/reasons")
    public List<Reason> listAllReasons() {
      return reasonService.findAll();
    }

    @GetMapping("/reasons/{id}")
    public ResponseEntity<Reason> getReasonById(@PathVariable Long id) {
        Reason reason = reasonService.findById(id);
        return new ResponseEntity<>(reason, HttpStatus.OK);
    }

    @PutMapping("/reasons/{id}")
    public ResponseEntity<Reason> updateReasonById(@RequestBody Reason reason) {
        Reason updatedReason = reasonService.update(reason);
        return new ResponseEntity<>(updatedReason, HttpStatus.OK);
    }

    @PostMapping("/reasons")
    public ResponseEntity<Reason> createReason(@RequestBody Reason reason) {
        Reason createdReason = reasonService.save(reason);
        return new ResponseEntity<>(createdReason, HttpStatus.CREATED);
    }

    @DeleteMapping("/reasons/{id}")
    public ResponseEntity<Reason> deleteReason(@PathVariable Long id) {
        reasonService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}


