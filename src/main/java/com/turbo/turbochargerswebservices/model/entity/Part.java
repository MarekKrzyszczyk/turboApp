package com.turbo.turbochargerswebservices.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "parts")
public class Part extends AbstractBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    public Part(String name) {
        this.name = name;
    }

    public Part() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
