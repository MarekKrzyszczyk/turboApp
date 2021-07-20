package com.turbo.turbochargerswebservices.model.dto.equipment;

import com.turbo.turbochargerswebservices.model.dto.CustomMapper;
import com.turbo.turbochargerswebservices.model.dto.Utils;
import com.turbo.turbochargerswebservices.model.entity.Equipment;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(uses = {Utils.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface EquipmentMapper extends CustomMapper<Equipment, EquipmentDto> {
}
