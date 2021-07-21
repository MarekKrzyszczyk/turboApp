//package com.turbo.turbochargerswebservices.model.dto.user;
//
//import com.turbo.turbochargerswebservices.model.dto.role.RoleDto;
//import com.turbo.turbochargerswebservices.model.dto.workgroup.WorkgroupDto;
//import com.turbo.turbochargerswebservices.model.entity.Role;
//import com.turbo.turbochargerswebservices.model.entity.User;
//import com.turbo.turbochargerswebservices.model.entity.Workgroup;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.ArrayList;
//import java.util.TreeSet;
//import java.util.List;
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class UserMapperTest {
//
//    private final UserMapper userMapper;
//
//    private static final User firstUser = new User();
//    private static final User secondUser = new User();
//    private static final UserDto firstUserDto = new UserDto();
//    private static final UserDto secondUserDto = new UserDto();
//
//    private static final String firstUserFirstName = "Marek";
//    private static final String secondUserFirstName = "Wojtek";
//    private static final String firstUserDtoFirstName = "Agnieszka";
//    private static final String secondUserDtoFirstName = "Iga";
//
//    private static final String firstUserLastName = "Nowak";
//    private static final String secondUserLastName = "Kowal";
//    private static final String firstUserDtoLastName = "Kulka";
//    private static final String secondUserDtoLastName = "Pastyl";
//
//    private static final Role firstUserFirstRole = new Role();
//    private static final Role firstUserSecondRole = new Role();
//    private static final Role secondUserFirstRole = new Role();
//    private static final Role secondUserSecondRole = new Role();
//    private static final RoleDto firstUserDtoFirstRole = new RoleDto();
//    private static final RoleDto firstUserDtoSecondRole = new RoleDto();
//    private static final RoleDto secondUserDtoFirstRole = new RoleDto();
//    private static final RoleDto secondUserDtoSecondRole = new RoleDto();
//
//    private static final Workgroup firstUserFirstWorkgroup = new Workgroup();
//    private static final Workgroup firstUserSecondWorkgroup = new Workgroup();
//    private static final Workgroup secondUserFirstWorkgroup = new Workgroup();
//    private static final Workgroup secondUserSecondWorkgroup = new Workgroup();
//    private static final WorkgroupDto firstUserDtoFirstWorkgroup = new WorkgroupDto();
//    private static final WorkgroupDto firstUserDtoSecondWorkgroup = new WorkgroupDto();
//    private static final WorkgroupDto secondUserDtoFirstWorkgroup = new WorkgroupDto();
//    private static final WorkgroupDto secondUserDtoSecondWorkgroup = new WorkgroupDto();
//
//    @Autowired
//    public UserMapperTest(UserMapper userMapper) {
//        this.userMapper = userMapper;
//    }
//
//    @BeforeAll
//    public static void setUp() {
//        firstUser.setId(1L);
//        firstUser.setFirstName(firstUserFirstName);
//        firstUser.setLastName(firstUserLastName);
//        firstUserFirstRole.setId(1L);
//        firstUserFirstRole.setName("Admin");
//        firstUserSecondRole.setId(2L);
//        firstUserSecondRole.setName("Seller");
//        Set<Role> firstUserRoles = new TreeSet<>();
//        firstUserRoles.add(firstUserFirstRole);
//        firstUserRoles.add(firstUserSecondRole);
//        firstUser.setRoles(firstUserRoles);
//        firstUserFirstWorkgroup.setId(1L);
//        firstUserFirstWorkgroup.setName("Technician");
//        firstUserSecondWorkgroup.setId(2L);
//        firstUserSecondWorkgroup.setName("Seller");
//        Set<Workgroup> firstUserWorkgroups = new TreeSet<>();
//        firstUserWorkgroups.add(firstUserFirstWorkgroup);
//        firstUserWorkgroups.add(firstUserSecondWorkgroup);
//        firstUser.setWorkgroups(firstUserWorkgroups);
//
//        secondUser.setId(2L);
//        secondUser.setFirstName(secondUserFirstName);
//        secondUser.setLastName(secondUserLastName);
//        secondUserFirstRole.setId(1L);
//        secondUserFirstRole.setName("Technician");
//        secondUserSecondRole.setId(2L);
//        secondUserSecondRole.setName("Owner");
//        Set<Role> secondUserRoles = new TreeSet<>();
//        secondUserRoles.add(secondUserFirstRole);
//        secondUserRoles.add(secondUserSecondRole);
//        secondUser.setRoles(secondUserRoles);
//        secondUserFirstWorkgroup.setId(1L);
//        secondUserFirstWorkgroup.setName("Technician");
//        secondUserSecondWorkgroup.setId(2L);
//        secondUserSecondWorkgroup.setName("Owner");
//        Set<Workgroup> secondUserWorkgroups = new TreeSet<>();
//        secondUserWorkgroups.add(secondUserFirstWorkgroup);
//        secondUserWorkgroups.add(secondUserSecondWorkgroup);
//        secondUser.setWorkgroups(secondUserWorkgroups);
//
//        firstUserDto.setId(3L);
//        firstUserDto.setFirstName(firstUserDtoFirstName);
//        firstUserDto.setLastName(firstUserDtoLastName);
//        firstUserDtoFirstRole.setId(1L);
//        firstUserDtoFirstRole.setName("Technician");
//        firstUserDtoSecondRole.setId(2L);
//        firstUserDtoSecondRole.setName("Owner");
//        Set<RoleDto> firstUserDtoRoles = new TreeSet<>();
//        firstUserDtoRoles.add(firstUserDtoFirstRole);
//        firstUserDtoRoles.add(firstUserDtoSecondRole);
//        firstUserDto.setRoles(firstUserDtoRoles);
//        firstUserDtoFirstWorkgroup.setId(1L);
//        firstUserDtoFirstWorkgroup.setName("Technician");
//        firstUserDtoSecondWorkgroup.setId(2L);
//        firstUserDtoSecondWorkgroup.setName("Owner");
//        Set<WorkgroupDto> firstUserDtoWorkgroups = new TreeSet<>();
//        firstUserDtoWorkgroups.add(firstUserDtoFirstWorkgroup);
//        firstUserDtoWorkgroups.add(firstUserDtoSecondWorkgroup);
//        firstUserDto.setWorkgroups(firstUserDtoWorkgroups);
//
//        secondUserDto.setId(4L);
//        secondUserDto.setFirstName(secondUserDtoFirstName);
//        secondUserDto.setLastName(secondUserDtoLastName);
//        secondUserDtoFirstRole.setId(1L);
//        secondUserDtoFirstRole.setName("Admin");
//        secondUserDtoSecondRole.setId(2L);
//        secondUserDtoSecondRole.setName("Owner");
//        Set<RoleDto> secondUserDtoRoles = new TreeSet<>();
//        secondUserDtoRoles.add(secondUserDtoFirstRole);
//        secondUserDtoRoles.add(secondUserDtoSecondRole);
//        secondUserDto.setRoles(secondUserDtoRoles);
//        secondUserDtoFirstWorkgroup.setId(1L);
//        secondUserDtoFirstWorkgroup.setName("Admin");
//        secondUserDtoSecondWorkgroup.setId(2L);
//        secondUserDtoSecondWorkgroup.setName("Owner");
//        Set<WorkgroupDto> secondUserDtoWorkgroups = new TreeSet<>();
//        secondUserDtoWorkgroups.add(secondUserDtoFirstWorkgroup);
//        secondUserDtoWorkgroups.add(secondUserDtoSecondWorkgroup);
//        secondUserDto.setWorkgroups(secondUserDtoWorkgroups);
//    }
//
//    @Test
//    void map_to_userDto_test() {
//
//        //when
//        UserDto userDto = userMapper.mapToDto(firstUser);
//
//        //then
//        assertEquals(1L, userDto.getId());
//        assertEquals(firstUserFirstName, userDto.getFirstName());
//        assertEquals(firstUserLastName, userDto.getLastName());
//
//        assertEquals(firstUser.getRoles().size(), userDto.getRoles().size());
//        assertEquals(firstUser.getRoles()..get(0).getId(), userDto.getRoles().get(0).getId());
//        assertEquals(firstUser.getRoles().get(0).getName(), userDto.getRoles().get(0).getName());
//        assertEquals(firstUser.getRoles().get(1).getId(), userDto.getRoles().get(1).getId());
//        assertEquals(firstUser.getRoles().get(1).getName(), userDto.getRoles().get(1).getName());
//
//        assertEquals(firstUser.getWorkgroups().size(), userDto.getWorkgroups().size());
//        assertEquals(firstUser.getWorkgroups().get(0).getId(), userDto.getWorkgroups().get(0).getId());
//        assertEquals(firstUser.getWorkgroups().get(0).getName(), userDto.getWorkgroups().get(0).getName());
//        assertEquals(firstUser.getWorkgroups().get(1).getId(), userDto.getWorkgroups().get(1).getId());
//        assertEquals(firstUser.getWorkgroups().get(1).getName(), userDto.getWorkgroups().get(1).getName());
//    }
//
//    @Test
//    void map_to_userDtoList_test() {
//
//        //given
//        List<User> users = new ArrayList<>();
//
//        users.add(firstUser);
//        users.add(secondUser);
//
//        //when
//        List<UserDto> usersDto = userMapper.mapToDtoList(users);
//
//        //then
//        assertEquals(users.size(), usersDto.size());
//
//        assertEquals(1L, usersDto.get(0).getId());
//        assertEquals(firstUserFirstName, usersDto.get(0).getFirstName());
//        assertEquals(firstUserLastName, usersDto.get(0).getLastName());
//
//        assertEquals(firstUser.getRoles().size(), usersDto.get(0).getRoles().size());
//        assertEquals(firstUser.getRoles().get(0).getId(), usersDto.get(0).getRoles().get(0).getId());
//        assertEquals(firstUser.getRoles().get(0).getName(), usersDto.get(0).getRoles().get(0).getName());
//        assertEquals(firstUser.getRoles().get(1).getName(), usersDto.get(0).getRoles().get(1).getName());
//
//        assertEquals(firstUser.getWorkgroups().size(), usersDto.get(0).getWorkgroups().size());
//        assertEquals(firstUser.getWorkgroups().get(0).getId(), usersDto.get(0).getWorkgroups().get(0).getId());
//        assertEquals(firstUser.getWorkgroups().get(0).getName(), usersDto.get(0).getWorkgroups().get(0).getName());
//        assertEquals(firstUser.getWorkgroups().get(1).getId(), usersDto.get(0).getWorkgroups().get(1).getId());
//        assertEquals(firstUser.getWorkgroups().get(1).getName(), usersDto.get(0).getWorkgroups().get(1).getName());
//
//        assertEquals(2L, usersDto.get(1).getId());
//        assertEquals(secondUserFirstName, usersDto.get(1).getFirstName());
//        assertEquals(secondUserLastName, usersDto.get(1).getLastName());
//
//        assertEquals(secondUser.getRoles().size(), usersDto.get(1).getRoles().size());
//        assertEquals(secondUser.getRoles().get(0).getId(), usersDto.get(1).getRoles().get(0).getId());
//        assertEquals(secondUser.getRoles().get(1).getId(), usersDto.get(1).getRoles().get(1).getId());
//        assertEquals(secondUser.getRoles().get(1).getName(), usersDto.get(1).getRoles().get(1).getName());
//
//        assertEquals(secondUser.getWorkgroups().size(), usersDto.get(1).getWorkgroups().size());
//        assertEquals(secondUser.getWorkgroups().get(0).getId(), usersDto.get(1).getWorkgroups().get(0).getId());
//        assertEquals(secondUser.getWorkgroups().get(0).getName(), usersDto.get(1).getWorkgroups().get(0).getName());
//        assertEquals(secondUser.getWorkgroups().get(1).getId(), usersDto.get(1).getWorkgroups().get(1).getId());
//    }
//
//    @Test
//    void map_to_user_test() {
//
//        //when
//        User user = userMapper.mapToEntity(firstUserDto);
//
//        //then
//        assertEquals(3L, user.getId());
//        assertEquals(firstUserDtoFirstName, user.getFirstName());
//        assertEquals(firstUserDtoLastName, user.getLastName());
//
//        assertEquals(firstUserDto.getRoles().size(), user.getRoles().size());
//        assertEquals(firstUserDto.getRoles().get(0).getId(), user.getRoles().get(0).getId());
//        assertEquals(firstUserDto.getRoles().get(0).getName(), user.getRoles().get(0).getName());
//        assertEquals(firstUserDto.getRoles().get(1).getId(), user.getRoles().get(1).getId());
//        assertEquals(firstUserDto.getRoles().get(1).getName(), user.getRoles().get(1).getName());
//
//        assertEquals(firstUserDto.getWorkgroups().size(), user.getWorkgroups().size());
//        assertEquals(firstUserDto.getWorkgroups().get(0).getId(), user.getWorkgroups().get(0).getId());
//        assertEquals(firstUserDto.getWorkgroups().get(0).getName(), user.getWorkgroups().get(0).getName());
//        assertEquals(firstUserDto.getWorkgroups().get(1).getId(), user.getWorkgroups().get(1).getId());
//        assertEquals(firstUserDto.getWorkgroups().get(1).getName(), user.getWorkgroups().get(1).getName());
//
//        assertNull(user.getUsername());
//        assertNull(user.getPassword());
//    }
//
//    @Test
//    void map_to_userList_test() {
//
//        //given
//        List<UserDto> usersDto = new ArrayList<>();
//
//        usersDto.add(firstUserDto);
//        usersDto.add(secondUserDto);
//
//        //when
//        List<User> users = userMapper.mapToEntitiesList(usersDto);
//
//        //then
//        assertEquals(usersDto.size(), users.size());
//
//        assertEquals(3L, users.get(0).getId());
//        assertEquals(firstUserDtoFirstName, users.get(0).getFirstName());
//        assertEquals(firstUserDtoLastName, users.get(0).getLastName());
//
//        assertEquals(firstUserDto.getRoles().size(), users.get(0).getRoles().size());
//        assertEquals(firstUserDto.getRoles().get(0).getId(), users.get(0).getRoles().get(0).getId());
//        assertEquals(firstUserDto.getRoles().get(0).getName(), users.get(0).getRoles().get(0).getName());
//        assertEquals(firstUserDto.getRoles().get(1).getId(), users.get(0).getRoles().get(1).getId());
//        assertEquals(firstUserDto.getRoles().get(1).getName(), users.get(0).getRoles().get(1).getName());
//
//        assertEquals(firstUserDto.getWorkgroups().size(), users.get(0).getWorkgroups().size());
//        assertEquals(firstUserDto.getWorkgroups().get(0).getName(), users.get(0).getWorkgroups().get(0).getName());
//        assertEquals(firstUserDto.getWorkgroups().get(1).getId(), users.get(0).getWorkgroups().get(1).getId());
//        assertEquals(firstUserDto.getWorkgroups().get(1).getName(), users.get(0).getWorkgroups().get(1).getName());
//
//        assertEquals(4L, users.get(1).getId());
//        assertEquals(secondUserDtoFirstName, users.get(1).getFirstName());
//        assertEquals(secondUserDtoLastName, users.get(1).getLastName());
//
//        assertEquals(secondUserDto.getRoles().size(), users.get(1).getRoles().size());
//        assertEquals(secondUserDto.getRoles().get(0).getId(), users.get(1).getRoles().get(0).getId());
//        assertEquals(secondUserDto.getRoles().get(1).getId(), users.get(1).getRoles().get(1).getId());
//        assertEquals(secondUserDto.getRoles().get(1).getName(), users.get(1).getRoles().get(1).getName());
//
//        assertEquals(secondUserDto.getWorkgroups().size(), users.get(1).getWorkgroups().size());
//        assertEquals(secondUserDto.getWorkgroups().get(0).getId(), users.get(1).getWorkgroups().get(0).getId());
//        assertEquals(secondUserDto.getWorkgroups().get(0).getName(), users.get(1).getWorkgroups().get(0).getName());
//        assertEquals(secondUserDto.getWorkgroups().get(1).getName(), users.get(1).getWorkgroups().get(1).getName());
//    }
//}