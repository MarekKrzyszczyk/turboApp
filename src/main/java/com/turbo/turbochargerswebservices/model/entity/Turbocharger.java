package com.turbo.turbochargerswebservices.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "turbochargers")
@Data
@NoArgsConstructor
public class Turbocharger extends AbstractBaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String number;

    @Column
    private String model;

    @Column
    private String producer;
}
