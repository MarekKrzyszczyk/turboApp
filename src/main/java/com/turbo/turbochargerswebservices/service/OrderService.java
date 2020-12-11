package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.entity.Order;

public interface OrderService extends AbstractBaseService<Order, Long> {

    void setDeletedAsTrue(Long id);
}
