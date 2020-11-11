package com.turbo.turbochargerswebservices.controller;

import com.turbo.turbochargerswebservices.model.Part;
import com.turbo.turbochargerswebservices.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PartController {

    private final PartService partService;

    @Autowired
    public PartController(PartService partService) {
        this.partService = partService;
    }

    @GetMapping("/parts")
    public List<Part> listAllParts() {
      return partService.getAllParts();
    }
}


