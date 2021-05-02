package com.turbo.turbochargerswebservices.model.dto.turbocharger;

import com.turbo.turbochargerswebservices.model.dto.AbstractBaseDto;
import lombok.Data;

@Data
public class TurbochargerDto extends AbstractBaseDto {

    private Long id;

    private String number;

    private String model;

    private String producer;
}
