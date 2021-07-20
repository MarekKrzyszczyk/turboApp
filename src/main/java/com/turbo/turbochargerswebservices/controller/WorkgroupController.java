package com.turbo.turbochargerswebservices.controller;

import com.turbo.turbochargerswebservices.model.dto.workgroup.WorkgroupDto;
import com.turbo.turbochargerswebservices.service.WorkgroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class WorkgroupController {

    private final WorkgroupService workgroupService;

    @Autowired
    public WorkgroupController(WorkgroupService workgroupService) {
        this.workgroupService = workgroupService;
    }

    @GetMapping("/workgroups")
    public ResponseEntity<List<WorkgroupDto>> listAllWorkgroups() {
        List<WorkgroupDto> workgroups = workgroupService.findAll();
        return new ResponseEntity<>(workgroups, HttpStatus.OK);
    }

    @PostMapping("/workgroups")
    public ResponseEntity<WorkgroupDto> createWorkgroups(@RequestBody WorkgroupDto workgroup) {
        WorkgroupDto createdWorkgroup = workgroupService.save(workgroup);
        return new ResponseEntity<>(createdWorkgroup, HttpStatus.CREATED);
    }
}