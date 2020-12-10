package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.dto.CustomerDto;
import com.turbo.turbochargerswebservices.model.entity.Customer;

import java.util.List;

public interface CustomerService extends AbstractBaseService<Customer, Long> {

    List<CustomerDto> listAllActive();

}
