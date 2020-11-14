package com.turbo.turbochargerswebservices.controller;

import com.turbo.turbochargerswebservices.model.Order;
import com.turbo.turbochargerswebservices.service.OrderService;
import com.turbo.turbochargerswebservices.service.PartService;
import com.turbo.turbochargerswebservices.service.ReasonService;
import com.turbo.turbochargerswebservices.service.TurbochargerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(TurbochargerService turbochargerService, PartService partService, ReasonService reasonService, OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public List<Order> listAllOrders() {
        return orderService.listAllOrders();
    }


    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = orderService.findOrderById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping("/orders")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order createdOrder = orderService.createOrder(order);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

}
