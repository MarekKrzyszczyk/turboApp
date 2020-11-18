package com.turbo.turbochargerswebservices.model.dto;

import com.turbo.turbochargerswebservices.model.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OrderMapperTest {

    OrderMapper orderMapper;

    @Autowired
    public OrderMapperTest(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Test
    public void shouldOrderToOrderDto() {
       //given
        Status status = new Status("nowe");
        Reason reason = new Reason("rdza");
        Part firstPart = new Part("tarcza");
        Part secondPart = new Part("kolo");
        Turbocharger turbocharger = new Turbocharger("Md-001");
        Order order = new Order(1L, LocalDate.of(2020, 11, 15), status, turbocharger, new ArrayList<>(Arrays.asList(firstPart, secondPart)), reason);

        //when
        OrderDto orderDto = orderMapper.orderToOrderDto(order);

        //then
        assertEquals(1L, orderDto.getId());
        assertEquals("2020-11-15", orderDto.getOrderDate());
        assertEquals("nowe", orderDto.getStatus());
        assertEquals("rdza", orderDto.getReason());
        assertEquals(new ArrayList<>(Arrays.asList("tarcza", "kolo")), orderDto.getParts());
        assertEquals("Md-001", orderDto.getTurbocharger());
    }
}