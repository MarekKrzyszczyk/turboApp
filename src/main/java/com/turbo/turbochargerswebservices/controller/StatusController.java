package com.turbo.turbochargerswebservices.controller;

import com.turbo.turbochargerswebservices.model.dto.status.StatusDto;
import com.turbo.turbochargerswebservices.service.StatusService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class StatusController {

    private final StatusService statusService;

    @Autowired
    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping("/statuses")
    public ResponseEntity<List<StatusDto>> listAllStatuses() {
        List<StatusDto> statuses = statusService.findAll();
        return new ResponseEntity<>(statuses, HttpStatus.OK);
    }

    @PostMapping("/statuses")
    public ResponseEntity<StatusDto> createStatus(@RequestBody StatusDto status) {
        StatusDto createdStatus = statusService.save(status);
        return new ResponseEntity<>(createdStatus, HttpStatus.CREATED);
    }

    @PutMapping("/statuses/{id}")
    public ResponseEntity<StatusDto> updateStatus(@RequestBody StatusDto status) throws NotFoundException {
        StatusDto updatedStatus = statusService.save(status);
        return new ResponseEntity<>(updatedStatus, HttpStatus.OK);
    }
}


