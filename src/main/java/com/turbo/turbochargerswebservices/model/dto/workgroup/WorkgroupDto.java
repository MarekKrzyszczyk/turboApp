package com.turbo.turbochargerswebservices.model.dto.workgroup;

import com.turbo.turbochargerswebservices.model.dto.AbstractBaseDto;
import lombok.Data;

@Data
public class WorkgroupDto extends AbstractBaseDto {

    private Long id;

    private String name;
}
