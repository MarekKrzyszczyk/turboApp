package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.entity.Order;

public interface OrderService extends AbstractBaseService<Order, Long> {

Order create(Order order);
    void setDeletedAsTrue(Long id);
}
