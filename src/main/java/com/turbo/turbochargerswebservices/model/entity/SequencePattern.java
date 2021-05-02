package com.turbo.turbochargerswebservices.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="patterns")
@Data
@NoArgsConstructor
public class SequencePattern extends AbstractBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer year;

    @Column
    private Integer month;

    @Column
    private String entity;

    @Column
    private String pattern;

    @Column
    private Integer currentNumber;
}
