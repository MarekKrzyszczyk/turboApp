package com.turbo.turbochargerswebservices.model.dto.part;

import com.turbo.turbochargerswebservices.model.dto.AbstractBaseDto;
import lombok.Data;

@Data
public class PartDto extends AbstractBaseDto {

    private Long id;

    private String name;
}
