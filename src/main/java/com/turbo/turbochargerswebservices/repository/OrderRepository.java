package com.turbo.turbochargerswebservices.repository;

import com.turbo.turbochargerswebservices.model.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends AbstractBaseRepository<Order, Long> {
}
