package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.dto.equipment.EquipmentDto;
import com.turbo.turbochargerswebservices.model.dto.equipment.EquipmentMapper;
import com.turbo.turbochargerswebservices.model.entity.Equipment;
import com.turbo.turbochargerswebservices.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentServiceImpl extends AbstractBaseServiceImpl<Equipment, EquipmentDto, Long> implements EquipmentService {

    @Autowired
    public EquipmentServiceImpl(EquipmentRepository equipmentRepository, EquipmentMapper equipmentMapper) {
        super(equipmentRepository, equipmentMapper);
    }
}
