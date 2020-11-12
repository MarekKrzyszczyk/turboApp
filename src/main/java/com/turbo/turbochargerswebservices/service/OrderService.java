package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.*;
import com.turbo.turbochargerswebservices.repository.OrderRepository;
import com.turbo.turbochargerswebservices.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final StatusRepository statusRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, StatusRepository statusRepository) {
        this.orderRepository = orderRepository;
        this.statusRepository = statusRepository;
    }


    public List<Order> listAllOrders(){
        return orderRepository.findAll();
    }

    public Order findOrderById(Long id) {
        Optional<Order> optOrder = orderRepository.findById(id);
        if (optOrder.isPresent()) {
            Order order = optOrder.get();
            return order;
        }
        return optOrder.orElse(new Order());
    }

    public Order createNewOrder(@RequestBody Order order) {
        orderRepository.save(order);
        return order;
    }
}
