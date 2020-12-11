package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.dto.CustomMapper;
import com.turbo.turbochargerswebservices.model.dto.CustomerDto;
import com.turbo.turbochargerswebservices.model.entity.Customer;
import com.turbo.turbochargerswebservices.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl extends AbstractBaseServiceImpl<Customer, Long> implements CustomerService{

    private CustomerRepository customerRepository;

    private final CustomMapper customMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomMapper customMapper) {
        super(customerRepository);
        this.customerRepository = customerRepository;
        this.customMapper = customMapper;
    }

    @Override
    public List<CustomerDto> listAllActive() {
        return customMapper.mapCustomers(customerRepository.findByDeletedFalse());
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
