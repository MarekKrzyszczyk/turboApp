package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.entity.Customer;
import com.turbo.turbochargerswebservices.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends AbstractBaseServiceImpl<Customer, Long> implements CustomerService{

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        super(customerRepository);
    }

}
