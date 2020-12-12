package com.turbo.turbochargerswebservices.repository;

import com.turbo.turbochargerswebservices.model.entity.SequencePattern;

public interface SequencePatternRepository extends AbstractBaseRepository<SequencePattern, Long> {

    SequencePattern findByYearAndMonthAndEntity(Integer year, Integer month, String entity);

}
