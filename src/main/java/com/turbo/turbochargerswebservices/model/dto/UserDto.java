package com.turbo.turbochargerswebservices.model.dto;

import com.turbo.turbochargerswebservices.model.entity.AbstractBaseEntity;
import com.turbo.turbochargerswebservices.model.entity.Role;
import com.turbo.turbochargerswebservices.model.entity.Workgroup;

import java.util.List;

public class UserDto extends AbstractBaseEntity {

    private Long id;

    private String firstName;

    private String lastName;

    private List<Role> roles;

    private List<Workgroup> workgroups;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Workgroup> getWorkgroups() {
        return workgroups;
    }

    public void setWorkgroups(List<Workgroup> workgroups) {
        this.workgroups = workgroups;
    }
}
