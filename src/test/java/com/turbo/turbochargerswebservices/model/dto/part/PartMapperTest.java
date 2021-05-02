package com.turbo.turbochargerswebservices.model.dto.part;

import com.turbo.turbochargerswebservices.model.entity.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PartMapperTest {

    private final PartMapper partMapper;

    private static final Part firstPart = new Part();
    private static final Part secondPart = new Part();
    private static final PartDto firstPartDto = new PartDto();
    private static final PartDto secondPartDto = new PartDto();

    private static final String firstPartName = "Koło";
    private static final String secondPartName = "Tarcza";
    private static final String firstPartDtoName = "Wałek";
    private static final String secondPartDtoName = "Pierścienie";

    @Autowired
    public PartMapperTest(PartMapper partMapper) {
        this.partMapper = partMapper;
    }

    @BeforeAll
    public static void setUp() {
        firstPart.setId(1L);
        firstPart.setName(firstPartName);

        secondPart.setId(2L);
        secondPart.setName(secondPartName);

        firstPartDto.setId(3L);
        firstPartDto.setName(firstPartDtoName);

        secondPartDto.setId(4L);
        secondPartDto.setName(secondPartDtoName);
    }

    @Test
    void map_to_partDto_test() {

        //when
        PartDto partDto = partMapper.mapToDto(firstPart);

        //then
        assertEquals(1L, partDto.getId());
        assertEquals(firstPartName, partDto.getName());
    }

    @Test
    void map_to_partDtoList_test() {

        //given
        List<Part> parts = new ArrayList<>();

        parts.add(firstPart);
        parts.add(secondPart);

        //when
        List<PartDto> partsDto = partMapper.mapToDtoList(parts);

        //then
        assertEquals(parts.size(), partsDto.size());

        assertEquals(1L, partsDto.get(0).getId());
        assertEquals(firstPartName, partsDto.get(0).getName());

        assertEquals(2L, partsDto.get(1).getId());
        assertEquals(secondPartName, partsDto.get(1).getName());
    }

    @Test
    void map_to_part_test() {

        //when
        Part part = partMapper.mapToEntity(firstPartDto);

        //then
        assertEquals(3L, part.getId());
        assertEquals(firstPartDtoName, part.getName());
    }

    @Test
    void map_to_partList_test() {

        //given
        List<PartDto> partsDto = new ArrayList<>();

        partsDto.add(firstPartDto);
        partsDto.add(secondPartDto);

        //when
        List<Part> parts = partMapper.mapToEntitiesList(partsDto);

        //then
        assertEquals(partsDto.size(), parts.size());

        assertEquals(3L, parts.get(0).getId());
        assertEquals(firstPartDtoName, parts.get(0).getName());

        assertEquals(4L, parts.get(1).getId());
        assertEquals(secondPartDtoName, parts.get(1).getName());
    }
}