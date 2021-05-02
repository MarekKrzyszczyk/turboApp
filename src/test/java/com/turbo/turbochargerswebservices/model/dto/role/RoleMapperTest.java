package com.turbo.turbochargerswebservices.model.dto.role;

import com.turbo.turbochargerswebservices.model.entity.Role;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoleMapperTest {

    private final RoleMapper roleMapper;

    private static final Role firstRole = new Role();
    private static final Role secondRole = new Role();
    private static final RoleDto firstRoleDto = new RoleDto();
    private static final RoleDto secondRoleDto = new RoleDto();

    private static final String firstRoleName = "Admin";
    private static final String secondRoleName = "Owner";
    private static final String firstRoleDtoName = "Seller";
    private static final String secondRoleDtoName = "Technician";

    @Autowired
    public RoleMapperTest(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @BeforeAll
    public static void setUp() {
        firstRole.setId(1L);
        firstRole.setName(firstRoleName);

        secondRole.setId(2L);
        secondRole.setName(secondRoleName);

        firstRoleDto.setId(3L);
        firstRoleDto.setName(firstRoleDtoName);

        secondRoleDto.setId(4L);
        secondRoleDto.setName(secondRoleDtoName);
    }

    @Test
    void map_to_roleDto_test() {

        //when
        RoleDto roleDto = roleMapper.mapToDto(firstRole);

        //then
        assertEquals(1L, roleDto.getId());
        assertEquals(firstRoleName, roleDto.getName());
    }

    @Test
    void map_to_roleDtoList_test() {

        //given
        List<Role> roles = new ArrayList<>();

        roles.add(firstRole);
        roles.add(secondRole);

        //when
        List<RoleDto> rolesDto = roleMapper.mapToDtoList(roles);

        //then
        assertEquals(roles.size(), rolesDto.size());

        assertEquals(1L, rolesDto.get(0).getId());
        assertEquals(firstRoleName, rolesDto.get(0).getName());

        assertEquals(2L, rolesDto.get(1).getId());
        assertEquals(secondRoleName, rolesDto.get(1).getName());
    }

    @Test
    void map_to_role_test() {

        //when
        Role role = roleMapper.mapToEntity(firstRoleDto);

        //then
        assertEquals(3L, role.getId());
        assertEquals(firstRoleDtoName, role.getName());
    }

    @Test
    void map_to_roleList_test() {

        //given
        List<RoleDto> rolesDto = new ArrayList<>();

        rolesDto.add(firstRoleDto);
        rolesDto.add(secondRoleDto);

        //when
        List<Role> roles = roleMapper.mapToEntitiesList(rolesDto);

        //then
        assertEquals(rolesDto.size(), roles.size());

        assertEquals(3L, roles.get(0).getId());
        assertEquals(firstRoleDtoName, roles.get(0).getName());

        assertEquals(4L, roles.get(1).getId());
        assertEquals(secondRoleDtoName, roles.get(1).getName());
    }

}