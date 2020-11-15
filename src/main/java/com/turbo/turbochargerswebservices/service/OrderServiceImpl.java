package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.dto.OrderDto;
import com.turbo.turbochargerswebservices.model.dto.OrderMapper;
import com.turbo.turbochargerswebservices.model.entity.Order;
import com.turbo.turbochargerswebservices.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl extends AbstractBaseServiceImpl<Order, Long> implements OrderService{

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper) {
        super(orderRepository);
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public List<OrderDto> listAllOrders(){
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(orderMapper::orderToOrderDto).collect(Collectors.toList());
    }

}
