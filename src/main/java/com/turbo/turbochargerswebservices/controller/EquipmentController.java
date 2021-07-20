package com.turbo.turbochargerswebservices.controller;

import com.turbo.turbochargerswebservices.model.dto.equipment.EquipmentDto;
import com.turbo.turbochargerswebservices.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EquipmentController {

    private final EquipmentService equipmentService;

    @Autowired
    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping("/equipments")
    public ResponseEntity<List<EquipmentDto>> listAllEquipments() {
        List<EquipmentDto> equipments = equipmentService.findAll();
        return new ResponseEntity<>(equipments, HttpStatus.OK);
    }

    @PostMapping("/equipments")
    public ResponseEntity<EquipmentDto> createEquipment(@RequestBody EquipmentDto equipment) {
        EquipmentDto createdEquipment = equipmentService.save(equipment);
        return new ResponseEntity<>(createdEquipment, HttpStatus.CREATED);
    }
}
