package com.turbo.turbochargerswebservices.model.dto;

import com.turbo.turbochargerswebservices.model.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CustomMapperTest {

   private final CustomMapper customMapper;

    @Autowired
    public CustomMapperTest(CustomMapper customMapper) {
        this.customMapper = customMapper;
    }

    @Test
    public void mapUsersTest() {
       //given

        List<User> users = new ArrayList<>();

        User firstUser = new User();
        firstUser.setId(1L);
        firstUser.setFirstName("Jan");
        firstUser.setLastName("Kowalski");

        User secondUser = new User();
        secondUser.setId(2L);
        secondUser.setFirstName("Marcin");
        secondUser.setLastName("Nowak");

        users.add(firstUser);
        users.add(secondUser);

        //when
        List<UserDto> usersDto = customMapper.mapUsers(users);

        //then
        assertEquals(1L, usersDto.get(0).getId());
        assertEquals("Jan", usersDto.get(0).getFirstName());
        assertEquals("Kowalski", usersDto.get(0).getLastName());

        assertEquals(2L, usersDto.get(1).getId());
        assertEquals("Marcin", usersDto.get(1).getFirstName());
        assertEquals("Nowak", usersDto.get(1).getLastName());

    }
}