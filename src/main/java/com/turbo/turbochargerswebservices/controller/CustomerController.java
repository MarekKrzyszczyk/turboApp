package com.turbo.turbochargerswebservices.controller;

import com.turbo.turbochargerswebservices.model.dto.CustomerDto;
import com.turbo.turbochargerswebservices.model.entity.Customer;
import com.turbo.turbochargerswebservices.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<CustomerDto> listAllCustomers() {
      return customerService.listAllActive();
    }


    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomers(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.save(customer);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id) {
        customerService.setDeletedAsTrue(id);
        return ResponseEntity.ok().build();
    }
}


