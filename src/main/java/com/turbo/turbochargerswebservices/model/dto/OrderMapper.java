package com.turbo.turbochargerswebservices.model.dto;

import com.turbo.turbochargerswebservices.model.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {CustomMapper.class}, componentModel = "spring")
public interface OrderMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "orderDate", target = "orderDate")
    @Mapping(source = "status.name", target = "status")
    @Mapping(source = "turbocharger.model", target = "turbocharger")
    @Mapping(source = "parts", target = "parts")
    @Mapping(source = "reason.name", target = "reason")
    OrderDto orderToOrderDto(Order order);
}
