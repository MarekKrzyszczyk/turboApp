package com.turbo.turbochargerswebservices.model.dto.reason;

import com.turbo.turbochargerswebservices.model.dto.AbstractBaseDto;
import lombok.Data;

@Data
public class ReasonDto extends AbstractBaseDto {

    private Long id;

    private String name;
}
