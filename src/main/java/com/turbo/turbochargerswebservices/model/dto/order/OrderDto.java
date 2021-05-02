package com.turbo.turbochargerswebservices.model.dto.order;

import com.turbo.turbochargerswebservices.model.dto.AbstractBaseDto;
import com.turbo.turbochargerswebservices.model.dto.part.PartDto;
import com.turbo.turbochargerswebservices.model.dto.reason.ReasonDto;
import com.turbo.turbochargerswebservices.model.dto.status.StatusDto;
import com.turbo.turbochargerswebservices.model.dto.turbocharger.TurbochargerDto;
import com.turbo.turbochargerswebservices.model.dto.user.UserDto;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class OrderDto extends AbstractBaseDto {

    private Long id;

    private LocalDate orderDate;

    private String notes;

    private String orderNumber;

    private StatusDto status;

    private TurbochargerDto turbocharger;

    private List<PartDto> parts;

    private ReasonDto reason;

    private UserDto seller;

    private UserDto technician;
}
