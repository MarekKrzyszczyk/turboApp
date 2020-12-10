package com.turbo.turbochargerswebservices.controller;

import com.turbo.turbochargerswebservices.model.entity.Status;
import com.turbo.turbochargerswebservices.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StatusController {

    private final StatusService statusService;

    @Autowired
    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping("/statuses")
    public List<Status> listAllStatuses() {
      return statusService.findAll();
    }


    @PostMapping("/statuses")
    public ResponseEntity<Status> createStatus(@RequestBody Status status) {
        Status createdStatus = statusService.save(status);
        return new ResponseEntity<>(createdStatus, HttpStatus.CREATED);
    }
}


