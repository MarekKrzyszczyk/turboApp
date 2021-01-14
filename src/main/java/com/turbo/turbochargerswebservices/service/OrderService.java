package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.dto.OrderDto;
import com.turbo.turbochargerswebservices.model.entity.Order;

import java.util.List;

public interface OrderService extends AbstractBaseService<Order, Long> {

    Order create(Order order);

    void setDeletedAsTrue(Long id);

    List<OrderDto> listAllOrders();
}
