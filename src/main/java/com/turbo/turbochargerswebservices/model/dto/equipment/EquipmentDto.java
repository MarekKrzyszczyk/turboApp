package com.turbo.turbochargerswebservices.model.dto.equipment;

import com.turbo.turbochargerswebservices.model.dto.AbstractBaseDto;
import lombok.Data;

@Data
public class EquipmentDto extends AbstractBaseDto {

    private Long id;

    private String name;
}
