package com.turbo.turbochargerswebservices.model.dto.customer;

import com.turbo.turbochargerswebservices.model.entity.Customer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerMapperTest {

    private final CustomerMapper customerMapper;

    private static final Customer firstCustomer = new Customer();
    private static final Customer secondCustomer = new Customer();
    private static final CustomerDto firstCustomerDto = new CustomerDto();
    private static final CustomerDto secondCustomerDto = new CustomerDto();

    private static final String firstCustomerFirstName = "Marek";
    private static final String secondCustomerFirstName = "Wojtek";
    private static final String firstCustomerDtoFirstName = "Agnieszka";
    private static final String secondCustomerDtoFirstName = "Iga";

    private static final String firstCustomerLastName = "Nowak";
    private static final String secondCustomerLastName = "Kowal";
    private static final String firstCustomerDtoLastName = "Kulka";
    private static final String secondCustomerDtoLastName = "Pastyl";

    private static final String firstCustomerPhone = "721444555";
    private static final String secondCustomerPhone = "787099732";
    private static final String firstCustomerDtoPhone = "503452678";
    private static final String secondCustomerDtoPhone = "605707808";

    @Autowired
    public CustomerMapperTest(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    @BeforeAll
    public static void setUp() {
        firstCustomer.setId(1L);
        firstCustomer.setFirstName(firstCustomerFirstName);
        firstCustomer.setLastName(firstCustomerLastName);
        firstCustomer.setPhone(firstCustomerPhone);

        secondCustomer.setId(2L);
        secondCustomer.setFirstName(secondCustomerFirstName);
        secondCustomer.setLastName(secondCustomerLastName);
        secondCustomer.setPhone(secondCustomerPhone);

        firstCustomerDto.setId(3L);
        firstCustomerDto.setFirstName(firstCustomerDtoFirstName);
        firstCustomerDto.setLastName(firstCustomerDtoLastName);
        firstCustomerDto.setPhone(firstCustomerDtoPhone);

        secondCustomerDto.setId(4L);
        secondCustomerDto.setFirstName(secondCustomerDtoFirstName);
        secondCustomerDto.setLastName(secondCustomerDtoLastName);
        secondCustomerDto.setPhone(secondCustomerDtoPhone);
    }

    @Test
    void map_to_customerDto_test() {

        //when
        CustomerDto customerDto = customerMapper.mapToDto(firstCustomer);

        //then
        assertEquals(1L, customerDto.getId());
        assertEquals(firstCustomerFirstName, customerDto.getFirstName());
        assertEquals(firstCustomerLastName, customerDto.getLastName());
        assertEquals(firstCustomerPhone, customerDto.getPhone());
    }

    @Test
    void map_to_customerDtoList_test() {

        //given
        List<Customer> customers = new ArrayList<>();

        customers.add(firstCustomer);
        customers.add(secondCustomer);

        //when
        List<CustomerDto> customersDto = customerMapper.mapToDtoList(customers);

        //then
        assertEquals(customers.size(), customersDto.size());

        assertEquals(1L, customersDto.get(0).getId());
        assertEquals(firstCustomerFirstName, customersDto.get(0).getFirstName());
        assertEquals(firstCustomerLastName, customersDto.get(0).getLastName());
        assertEquals(firstCustomerPhone, customersDto.get(0).getPhone());

        assertEquals(2L, customersDto.get(1).getId());
        assertEquals(secondCustomerFirstName, customersDto.get(1).getFirstName());
        assertEquals(secondCustomerLastName, customersDto.get(1).getLastName());
        assertEquals(secondCustomerPhone, customersDto.get(1).getPhone());
    }

    @Test
    void map_to_customer_test() {

        //when
        Customer customer = customerMapper.mapToEntity(firstCustomerDto);

        //then
        assertEquals(3L, customer.getId());
        assertEquals(firstCustomerDtoFirstName, customer.getFirstName());
        assertEquals(firstCustomerDtoLastName, customer.getLastName());
        assertEquals(firstCustomerDtoPhone, customer.getPhone());
    }

    @Test
    void map_to_customerList_test() {

        //given
        List<CustomerDto> customersDto = new ArrayList<>();

        customersDto.add(firstCustomerDto);
        customersDto.add(secondCustomerDto);

        //when
        List<Customer> customers = customerMapper.mapToEntitiesList(customersDto);

        //then
        assertEquals(customersDto.size(), customers.size());

        assertEquals(3L, customers.get(0).getId());
        assertEquals(firstCustomerDtoFirstName, customers.get(0).getFirstName());
        assertEquals(firstCustomerDtoLastName, customers.get(0).getLastName());
        assertEquals(firstCustomerDtoPhone, customers.get(0).getPhone());
        assertFalse(customers.get(0).isDeleted());

        assertEquals(4L, customers.get(1).getId());
        assertEquals(secondCustomerDtoFirstName, customers.get(1).getFirstName());
        assertEquals(secondCustomerDtoLastName, customers.get(1).getLastName());
        assertEquals(secondCustomerDtoPhone, customers.get(1).getPhone());
        assertFalse(customers.get(1).isDeleted());
    }
}