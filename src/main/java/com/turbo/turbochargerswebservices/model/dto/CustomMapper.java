package com.turbo.turbochargerswebservices.model.dto;

import com.turbo.turbochargerswebservices.model.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDate;
import java.util.List;

@Mapper(uses = {Utils.class}, componentModel = "spring")
public interface CustomMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "roles", target = "roles")
    @Mapping(source = "workgroups", target = "workgroups")
    List<UserDto> mapUsers(List<User> users);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "phone", target = "phone")
    List<CustomerDto> mapCustomers(List<Customer> customers);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "orderDate", target = "orderDate")
    @Mapping(source = "notes", target = "notes")
    @Mapping(source = "deleted", target = "deleted")
    @Mapping(source = "orderNumber", target = "orderNumber")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "turbocharger", target = "turbocharger")
    @Mapping(source = "parts", target = "parts")
    @Mapping(source = "reason", target = "reason")
    @Mapping(source = "seller", target = "seller")
    @Mapping(source = "technician", target = "technician")
    List<OrderDto> mapOrders(List<Order> orders);
}
