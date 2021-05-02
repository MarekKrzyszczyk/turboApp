package com.turbo.turbochargerswebservices.model.dto.status;

import com.turbo.turbochargerswebservices.model.entity.Status;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StatusMapperTest {

    private final StatusMapper statusMapper;

    private static final Status firstStatus = new Status();
    private static final Status secondStatus = new Status();
    private static final StatusDto firstStatusDto = new StatusDto();
    private static final StatusDto secondStatusDto = new StatusDto();

    private static final String firstStatusName = "Nowe";
    private static final String secondStatusName = "W trakcie";
    private static final String firstStatusDtoName = "Zakończone";
    private static final String secondStatusDtoName = "Anulowane";

    @Autowired
    public StatusMapperTest(StatusMapper statusMapper) {
        this.statusMapper = statusMapper;
    }

    @BeforeAll
    public static void setUp() {
        firstStatus.setId(1L);
        firstStatus.setName(firstStatusName);

        secondStatus.setId(2L);
        secondStatus.setName(secondStatusName);

        firstStatusDto.setId(3L);
        firstStatusDto.setName(firstStatusDtoName);

        secondStatusDto.setId(4L);
        secondStatusDto.setName(secondStatusDtoName);
    }

    @Test
    void map_to_statusDto_test() {

        //when
        StatusDto statusDto = statusMapper.mapToDto(firstStatus);

        //then
        assertEquals(1L, statusDto.getId());
        assertEquals(firstStatusName, statusDto.getName());
    }

    @Test
    void map_to_statusDtoList_test() {

        //given
        List<Status> statuss = new ArrayList<>();

        statuss.add(firstStatus);
        statuss.add(secondStatus);

        //when
        List<StatusDto> statussDto = statusMapper.mapToDtoList(statuss);

        //then
        assertEquals(statuss.size(), statussDto.size());

        assertEquals(1L, statussDto.get(0).getId());
        assertEquals(firstStatusName, statussDto.get(0).getName());

        assertEquals(2L, statussDto.get(1).getId());
        assertEquals(secondStatusName, statussDto.get(1).getName());
    }

    @Test
    void map_to_status_test() {

        //when
        Status status = statusMapper.mapToEntity(firstStatusDto);

        //then
        assertEquals(3L, status.getId());
        assertEquals(firstStatusDtoName, status.getName());
    }

    @Test
    void map_to_statusList_test() {

        //given
        List<StatusDto> statussDto = new ArrayList<>();

        statussDto.add(firstStatusDto);
        statussDto.add(secondStatusDto);

        //when
        List<Status> statuss = statusMapper.mapToEntitiesList(statussDto);

        //then
        assertEquals(statussDto.size(), statuss.size());

        assertEquals(3L, statuss.get(0).getId());
        assertEquals(firstStatusDtoName, statuss.get(0).getName());

        assertEquals(4L, statuss.get(1).getId());
        assertEquals(secondStatusDtoName, statuss.get(1).getName());
    }

}