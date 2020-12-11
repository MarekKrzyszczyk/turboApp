package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.entity.Order;
import com.turbo.turbochargerswebservices.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl extends AbstractBaseServiceImpl<Order, Long> implements OrderService{

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        super(orderRepository);
        this.orderRepository = orderRepository;
    }

    @Override
    public void setDeletedAsTrue(Long id) {
        Optional<Order> optOrder = orderRepository.findById(id);
        if(optOrder.isPresent()) {
            Order deletedOrder = optOrder.get();
            deletedOrder.setDeleted(true);
            orderRepository.save(deletedOrder);
        }
    }

}
