package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.dto.customer.CustomerDto;

import java.util.List;

public interface CustomerService extends AbstractBaseService<CustomerDto, Long> {

    List<CustomerDto> listAllActive();

    void setDeletedAsTrue(Long id);
}
