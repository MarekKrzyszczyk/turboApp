package com.turbo.turbochargerswebservices.controller;

import com.turbo.turbochargerswebservices.model.dto.customer.CustomerDto;
import com.turbo.turbochargerswebservices.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDto>> listAllCustomers() {
        List<CustomerDto> customers = customerService.listAllActive();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping("/customers")
    public ResponseEntity<CustomerDto> createCustomers(@RequestBody CustomerDto customer) {
        CustomerDto createdCustomer = customerService.save(customer);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<CustomerDto> deleteCustomer(@PathVariable Long id) {
        customerService.setDeletedAsTrue(id);
        return ResponseEntity.ok().build();
    }
}