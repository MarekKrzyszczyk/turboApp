package com.turbo.turbochargerswebservices.controller;

import com.turbo.turbochargerswebservices.model.dto.reason.ReasonDto;
import com.turbo.turbochargerswebservices.service.ReasonService;
import javassist.NotFoundException;
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
    public ResponseEntity<List<ReasonDto>> listAllReasons() {
        List<ReasonDto> reasons = reasonService.findAll();
        return new ResponseEntity<>(reasons, HttpStatus.OK);
    }

    @GetMapping("/reasons/{id}")
    public ResponseEntity<ReasonDto> getReasonById(@PathVariable Long id) {
        ReasonDto reason = reasonService.findById(id);
        return new ResponseEntity<>(reason, HttpStatus.OK);
    }

    @PostMapping("/reasons")
    public ResponseEntity<ReasonDto> createReason(@RequestBody ReasonDto reason) {
        ReasonDto createdReason = reasonService.save(reason);
        return new ResponseEntity<>(createdReason, HttpStatus.CREATED);
    }

    @PutMapping("/reasons/{id}")
    public ResponseEntity<ReasonDto> updateReason(@RequestBody ReasonDto reason) {
        ReasonDto updatedReason = reasonService.save(reason);
        return new ResponseEntity<>(updatedReason, HttpStatus.OK);
    }

    @DeleteMapping("/reasons/{id}")
    public ResponseEntity<ReasonDto> deleteReason(@PathVariable Long id) {
        reasonService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}


