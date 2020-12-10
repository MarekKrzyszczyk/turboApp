package com.turbo.turbochargerswebservices.repository;

import com.turbo.turbochargerswebservices.model.entity.Customer;

import java.util.List;

public interface CustomerRepository extends AbstractBaseRepository<Customer, Long> {

    List<Customer> findByDeletedFalse();

}
