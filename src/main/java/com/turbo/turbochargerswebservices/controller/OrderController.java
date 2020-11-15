package com.turbo.turbochargerswebservices.controller;

import com.turbo.turbochargerswebservices.model.dto.OrderDto;
import com.turbo.turbochargerswebservices.model.dto.OrderMapper;
import com.turbo.turbochargerswebservices.model.entity.Order;
import com.turbo.turbochargerswebservices.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    private final OrderServiceImpl orderServiceImpl;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderController(OrderServiceImpl orderServiceImpl, OrderMapper orderMapper) {
        this.orderServiceImpl = orderServiceImpl;
        this.orderMapper = orderMapper;
    }

    @GetMapping("/orders")
    public List<OrderDto> listAllOrders() {
        return orderServiceImpl.listAllOrders();
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long id) {
        Order order = orderServiceImpl.findById(id);
        OrderDto orderDto = orderMapper.orderToOrderDto(order);
        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }

    @PostMapping("/orders")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order createdOrder = orderServiceImpl.save(order);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

}
