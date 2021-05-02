package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.dto.customer.CustomerDto;
import com.turbo.turbochargerswebservices.model.dto.customer.CustomerMapper;
import com.turbo.turbochargerswebservices.model.entity.Customer;
import com.turbo.turbochargerswebservices.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl extends AbstractBaseServiceImpl<Customer, CustomerDto, Long> implements CustomerService{

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        super(customerRepository, customerMapper);
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<CustomerDto> listAllActive() {
        List<Customer> customers = customerRepository.findByDeletedFalse();
        return customerMapper.mapToDtoList(customers);
    }

    @Override
    public void setDeletedAsTrue(Long id) {
        Optional<Customer> optCustomer = customerRepository.findById(id);
        if(optCustomer.isPresent()) {
           Customer deletedCustomer = optCustomer.get();
           deletedCustomer.setDeleted(true);
           customerRepository.save(deletedCustomer);
        }
    }
}
