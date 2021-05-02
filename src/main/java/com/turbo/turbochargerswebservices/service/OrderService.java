package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.dto.order.OrderDto;

import java.util.List;

public interface OrderService extends AbstractBaseService<OrderDto, Long> {

    OrderDto create(OrderDto order);

    void setDeletedAsTrue(Long id);

    List<OrderDto> listAllOrders();
}
