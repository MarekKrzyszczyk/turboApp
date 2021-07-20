package com.turbo.turbochargerswebservices.model.dto.order;

import com.turbo.turbochargerswebservices.model.dto.CustomMapper;
import com.turbo.turbochargerswebservices.model.dto.Utils;
import com.turbo.turbochargerswebservices.model.dto.equipment.EquipmentMapper;
import com.turbo.turbochargerswebservices.model.dto.part.PartMapper;
import com.turbo.turbochargerswebservices.model.dto.reason.ReasonMapper;
import com.turbo.turbochargerswebservices.model.dto.status.StatusMapper;
import com.turbo.turbochargerswebservices.model.dto.turbocharger.TurbochargerMapper;
import com.turbo.turbochargerswebservices.model.dto.user.UserMapper;
import com.turbo.turbochargerswebservices.model.entity.Order;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(uses = {Utils.class, StatusMapper.class, TurbochargerMapper.class, PartMapper.class, ReasonMapper.class,
        UserMapper.class, EquipmentMapper.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface OrderMapper extends CustomMapper<Order, OrderDto> {

}
