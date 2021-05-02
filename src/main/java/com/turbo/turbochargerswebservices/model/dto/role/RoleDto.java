package com.turbo.turbochargerswebservices.model.dto.role;

import com.turbo.turbochargerswebservices.model.dto.AbstractBaseDto;
import lombok.Data;

@Data
public class RoleDto extends AbstractBaseDto {

    private Long id;

    private String name;
}
