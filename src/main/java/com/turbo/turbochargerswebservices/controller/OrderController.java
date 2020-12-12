package com.turbo.turbochargerswebservices.controller;

import com.turbo.turbochargerswebservices.model.entity.Order;
import com.turbo.turbochargerswebservices.service.OrderService;
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
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public List<Order> listAllOrders() {
        return orderService.findAll();
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = orderService.findById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping("/orders")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order createdOrder = orderService.save(order);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<Order> deleteOrder(@PathVariable Long id) {
        orderService.setDeletedAsTrue(id);
        return ResponseEntity.ok().build();
    }

}
