package com.turbo.turbochargerswebservices.model.dto.reason;

import com.turbo.turbochargerswebservices.model.entity.Reason;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReasonMapperTest {
    
    private final ReasonMapper reasonMapper;

    private static final Reason firstReason = new Reason();
    private static final Reason secondReason = new Reason();
    private static final ReasonDto firstReasonDto = new ReasonDto();
    private static final ReasonDto secondReasonDto = new ReasonDto();

    private static final String firstReasonName = "Brud";
    private static final String secondReasonName = "Rdza";
    private static final String firstReasonDtoName = "Ciało obce";
    private static final String secondReasonDtoName = "Uszkodzenie mechaniczne";

    @Autowired
    public ReasonMapperTest(ReasonMapper reasonMapper) {
        this.reasonMapper = reasonMapper;
    }

    @BeforeAll
    public static void setUp() {
        firstReason.setId(1L);
        firstReason.setName(firstReasonName);

        secondReason.setId(2L);
        secondReason.setName(secondReasonName);

        firstReasonDto.setId(3L);
        firstReasonDto.setName(firstReasonDtoName);

        secondReasonDto.setId(4L);
        secondReasonDto.setName(secondReasonDtoName);
    }

    @Test
    void map_to_reasonDto_test() {

        //when
        ReasonDto reasonDto = reasonMapper.mapToDto(firstReason);

        //then
        assertEquals(1L, reasonDto.getId());
        assertEquals(firstReasonName, reasonDto.getName());
    }

    @Test
    void map_to_reasonDtoList_test() {

        //given
        List<Reason> reasons = new ArrayList<>();

        reasons.add(firstReason);
        reasons.add(secondReason);

        //when
        List<ReasonDto> reasonsDto = reasonMapper.mapToDtoList(reasons);

        //then
        assertEquals(reasons.size(), reasonsDto.size());

        assertEquals(1L, reasonsDto.get(0).getId());
        assertEquals(firstReasonName, reasonsDto.get(0).getName());

        assertEquals(2L, reasonsDto.get(1).getId());
        assertEquals(secondReasonName, reasonsDto.get(1).getName());
    }

    @Test
    void map_to_reason_test() {

        //when
        Reason reason = reasonMapper.mapToEntity(firstReasonDto);

        //then
        assertEquals(3L, reason.getId());
        assertEquals(firstReasonDtoName, reason.getName());
    }

    @Test
    void map_to_reasonList_test() {

        //given
        List<ReasonDto> reasonsDto = new ArrayList<>();

        reasonsDto.add(firstReasonDto);
        reasonsDto.add(secondReasonDto);

        //when
        List<Reason> reasons = reasonMapper.mapToEntitiesList(reasonsDto);

        //then
        assertEquals(reasonsDto.size(), reasons.size());

        assertEquals(3L, reasons.get(0).getId());
        assertEquals(firstReasonDtoName, reasons.get(0).getName());

        assertEquals(4L, reasons.get(1).getId());
        assertEquals(secondReasonDtoName, reasons.get(1).getName());
    }

}