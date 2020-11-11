package com.turbo.turbochargerswebservices.controller;

import com.turbo.turbochargerswebservices.model.Reason;
import com.turbo.turbochargerswebservices.service.ReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ReasonController {

    private final ReasonService reasonService;

    @Autowired
    public ReasonController(ReasonService reasonService) {
        this.reasonService = reasonService;
    }

    @GetMapping("/reasons")
    public List<Reason> listAllReasons() {
      return reasonService.getAllReasons();
    }
}


