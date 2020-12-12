package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.entity.SequencePattern;

import java.time.LocalDate;

public interface SequencePatternService extends AbstractBaseService<SequencePattern, Long> {


    void increaseCurrentNumber(SequencePattern sequencePattern);

    SequencePattern create(String entity, String patternPrefix);

    SequencePattern findByYearAndMonthAndEntity(LocalDate sequenceDate, String entity);

    String getSequenceNumber(SequencePattern sequencePattern);

}
