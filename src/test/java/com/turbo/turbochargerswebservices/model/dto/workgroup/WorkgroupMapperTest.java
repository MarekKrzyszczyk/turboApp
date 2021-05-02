package com.turbo.turbochargerswebservices.model.dto.workgroup;

import com.turbo.turbochargerswebservices.model.entity.Workgroup;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WorkgroupMapperTest {
    
    private final WorkgroupMapper workgroupMapper;

    private static final Workgroup firstWorkgroup = new Workgroup();
    private static final Workgroup secondWorkgroup = new Workgroup();
    private static final WorkgroupDto firstWorkgroupDto = new WorkgroupDto();
    private static final WorkgroupDto secondWorkgroupDto = new WorkgroupDto();

    private static final String firstWorkgroupName = "Sprzedawca";
    private static final String secondWorkgroupName = "Technik";
    private static final String firstWorkgroupDtoName = "Kierownik";
    private static final String secondWorkgroupDtoName = "Właściciel";

    @Autowired
    public WorkgroupMapperTest(WorkgroupMapper workgroupMapper) {
        this.workgroupMapper = workgroupMapper;
    }

    @BeforeAll
    public static void setUp() {
        firstWorkgroup.setId(1L);
        firstWorkgroup.setName(firstWorkgroupName);

        secondWorkgroup.setId(2L);
        secondWorkgroup.setName(secondWorkgroupName);

        firstWorkgroupDto.setId(3L);
        firstWorkgroupDto.setName(firstWorkgroupDtoName);

        secondWorkgroupDto.setId(4L);
        secondWorkgroupDto.setName(secondWorkgroupDtoName);
    }

    @Test
    void map_to_workgroupDto_test() {

        //when
        WorkgroupDto workgroupDto = workgroupMapper.mapToDto(firstWorkgroup);

        //then
        assertEquals(1L, workgroupDto.getId());
        assertEquals(firstWorkgroupName, workgroupDto.getName());
    }

    @Test
    void map_to_workgroupDtoList_test() {

        //given
        List<Workgroup> workgroups = new ArrayList<>();

        workgroups.add(firstWorkgroup);
        workgroups.add(secondWorkgroup);

        //when
        List<WorkgroupDto> workgroupsDto = workgroupMapper.mapToDtoList(workgroups);

        //then
        assertEquals(workgroups.size(), workgroupsDto.size());

        assertEquals(1L, workgroupsDto.get(0).getId());
        assertEquals(firstWorkgroupName, workgroupsDto.get(0).getName());

        assertEquals(2L, workgroupsDto.get(1).getId());
        assertEquals(secondWorkgroupName, workgroupsDto.get(1).getName());
    }

    @Test
    void map_to_workgroup_test() {

        //when
        Workgroup workgroup = workgroupMapper.mapToEntity(firstWorkgroupDto);

        //then
        assertEquals(3L, workgroup.getId());
        assertEquals(firstWorkgroupDtoName, workgroup.getName());
    }

    @Test
    void map_to_workgroupList_test() {

        //given
        List<WorkgroupDto> workgroupsDto = new ArrayList<>();

        workgroupsDto.add(firstWorkgroupDto);
        workgroupsDto.add(secondWorkgroupDto);

        //when
        List<Workgroup> workgroups = workgroupMapper.mapToEntitiesList(workgroupsDto);

        //then
        assertEquals(workgroupsDto.size(), workgroups.size());

        assertEquals(3L, workgroups.get(0).getId());
        assertEquals(firstWorkgroupDtoName, workgroups.get(0).getName());

        assertEquals(4L, workgroups.get(1).getId());
        assertEquals(secondWorkgroupDtoName, workgroups.get(1).getName());
    }

}