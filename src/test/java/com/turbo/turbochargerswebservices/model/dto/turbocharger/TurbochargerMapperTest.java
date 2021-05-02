package com.turbo.turbochargerswebservices.model.dto.turbocharger;

import com.turbo.turbochargerswebservices.model.entity.Turbocharger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TurbochargerMapperTest {

    private final TurbochargerMapper turbochargerMapper;

    private static final Turbocharger firstTurbocharger = new Turbocharger();
    private static final Turbocharger secondTurbocharger = new Turbocharger();
    private static final TurbochargerDto firstTurbochargerDto = new TurbochargerDto();
    private static final TurbochargerDto secondTurbochargerDto = new TurbochargerDto();

    private static final String firstTurbochargerNumber = "123-456";
    private static final String secondTurbochargerNumber = "234-567";
    private static final String firstTurbochargerDtoNumber = "333-984";
    private static final String secondTurbochargerDtoNumber = "111-668";

    private static final String firstTurbochargerModel = "GT";
    private static final String secondTurbochargerModel = "BA";
    private static final String firstTurbochargerDtoModel = "WKY";
    private static final String secondTurbochargerDtoModel = "OPR";

    private static final String firstTurbochargerProducer = "Gellert";
    private static final String secondTurbochargerProducer = "Turbik";
    private static final String firstTurbochargerDtoProducer = "Turbik";
    private static final String secondTurbochargerDtoProducer = "Gellert";

    @Autowired
    public TurbochargerMapperTest(TurbochargerMapper turbochargerMapper) {
        this.turbochargerMapper = turbochargerMapper;
    }

    @BeforeAll
    public static void setUp() {
        firstTurbocharger.setId(1L);
        firstTurbocharger.setNumber(firstTurbochargerNumber);
        firstTurbocharger.setModel(firstTurbochargerModel);
        firstTurbocharger.setProducer(firstTurbochargerProducer);

        secondTurbocharger.setId(2L);
        secondTurbocharger.setNumber(secondTurbochargerNumber);
        secondTurbocharger.setModel(secondTurbochargerModel);
        secondTurbocharger.setProducer(secondTurbochargerProducer);

        firstTurbochargerDto.setId(3L);
        firstTurbochargerDto.setNumber(firstTurbochargerDtoNumber);
        firstTurbochargerDto.setModel(firstTurbochargerDtoModel);
        firstTurbochargerDto.setProducer(firstTurbochargerDtoProducer);

        secondTurbochargerDto.setId(4L);
        secondTurbochargerDto.setNumber(secondTurbochargerDtoNumber);
        secondTurbochargerDto.setModel(secondTurbochargerDtoModel);
        secondTurbochargerDto.setProducer(secondTurbochargerDtoProducer);
    }

    @Test
    void map_to_turbochargerDto_test() {

        //when
        TurbochargerDto turbochargerDto = turbochargerMapper.mapToDto(firstTurbocharger);

        //then
        assertEquals(1L, turbochargerDto.getId());
        assertEquals(firstTurbochargerNumber, turbochargerDto.getNumber());
        assertEquals(firstTurbochargerModel, turbochargerDto.getModel());
        assertEquals(firstTurbochargerProducer, turbochargerDto.getProducer());
    }

    @Test
    void map_to_turbochargerDtoList_test() {

        //given
        List<Turbocharger> turbochargers = new ArrayList<>();

        turbochargers.add(firstTurbocharger);
        turbochargers.add(secondTurbocharger);

        //when
        List<TurbochargerDto> turbochargersDto = turbochargerMapper.mapToDtoList(turbochargers);

        //then
        assertEquals(turbochargers.size(), turbochargersDto.size());

        assertEquals(1L, turbochargersDto.get(0).getId());
        assertEquals(firstTurbochargerNumber, turbochargersDto.get(0).getNumber());
        assertEquals(firstTurbochargerModel, turbochargersDto.get(0).getModel());
        assertEquals(firstTurbochargerProducer, turbochargersDto.get(0).getProducer());

        assertEquals(2L, turbochargersDto.get(1).getId());
        assertEquals(secondTurbochargerNumber, turbochargersDto.get(1).getNumber());
        assertEquals(secondTurbochargerModel, turbochargersDto.get(1).getModel());
        assertEquals(secondTurbochargerProducer, turbochargersDto.get(1).getProducer());
    }

    @Test
    void map_to_turbocharger_test() {

        //when
        Turbocharger turbocharger = turbochargerMapper.mapToEntity(firstTurbochargerDto);

        //then
        assertEquals(3L, turbocharger.getId());
        assertEquals(firstTurbochargerDtoNumber, turbocharger.getNumber());
        assertEquals(firstTurbochargerDtoModel, turbocharger.getModel());
        assertEquals(firstTurbochargerDtoProducer, turbocharger.getProducer());
    }

    @Test
    void map_to_turbochargerList_test() {

        //given
        List<TurbochargerDto> turbochargersDto = new ArrayList<>();

        turbochargersDto.add(firstTurbochargerDto);
        turbochargersDto.add(secondTurbochargerDto);

        //when
        List<Turbocharger> turbochargers = turbochargerMapper.mapToEntitiesList(turbochargersDto);

        //then
        assertEquals(turbochargersDto.size(), turbochargers.size());

        assertEquals(3L, turbochargers.get(0).getId());
        assertEquals(firstTurbochargerDtoNumber, turbochargers.get(0).getNumber());
        assertEquals(firstTurbochargerDtoModel, turbochargers.get(0).getModel());
        assertEquals(firstTurbochargerDtoProducer, turbochargers.get(0).getProducer());

        assertEquals(4L, turbochargers.get(1).getId());
        assertEquals(secondTurbochargerDtoNumber, turbochargers.get(1).getNumber());
        assertEquals(secondTurbochargerDtoModel, turbochargers.get(1).getModel());
        assertEquals(secondTurbochargerDtoProducer, turbochargers.get(1).getProducer());
    }
}