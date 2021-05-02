package com.turbo.turbochargerswebservices.model.dto.customer;

import com.turbo.turbochargerswebservices.model.dto.AbstractBaseDto;
import lombok.Data;

@Data
public class CustomerDto extends AbstractBaseDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String phone;

}
