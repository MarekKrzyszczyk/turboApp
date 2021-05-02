package com.turbo.turbochargerswebservices.model.dto.status;

import com.turbo.turbochargerswebservices.model.dto.AbstractBaseDto;
import lombok.Data;

@Data
public class StatusDto extends AbstractBaseDto {

    private Long id;

    private String name;
}
