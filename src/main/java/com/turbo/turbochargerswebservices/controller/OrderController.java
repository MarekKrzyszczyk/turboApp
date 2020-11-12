package com.turbo.turbochargerswebservices.controller;

import com.turbo.turbochargerswebservices.model.Order;
import com.turbo.turbochargerswebservices.model.Turbocharger;
import com.turbo.turbochargerswebservices.service.OrderService;
import com.turbo.turbochargerswebservices.service.PartService;
import com.turbo.turbochargerswebservices.service.ReasonService;
import com.turbo.turbochargerswebservices.service.TurbochargerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

//    @PostMapping("/create")
//    public String createNewOrder(@RequestBody Order order, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "newOrder";
//        }
//        orderService.createNewOrder(order.getTurbocharger(), order.getParts(), order.getReason());
//        return "redirect:/orderslist";
//
//    }

}
