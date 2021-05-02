package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.entity.SequencePattern;
import com.turbo.turbochargerswebservices.repository.SequencePatternRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SequencePatternServiceImpl implements SequencePatternService {

    private final SequencePatternRepository sequencePatternRepository;

    @Autowired
    public SequencePatternServiceImpl(SequencePatternRepository sequencePatternRepository) {
        this.sequencePatternRepository = sequencePatternRepository;
    }

    @Override
    public void increaseCurrentNumber(SequencePattern sequencePattern) {
        Integer increasedNumber = sequencePattern.getCurrentNumber() + 1;
        sequencePattern.setCurrentNumber(increasedNumber);
        sequencePatternRepository.save(sequencePattern);
    }

    @Override
    public SequencePattern create(String entity, String patternPrefix) {
        SequencePattern sequencePattern = new SequencePattern();
        LocalDate currentDate = LocalDate.now();
        sequencePattern.setYear(currentDate.getYear());
        sequencePattern.setMonth(currentDate.getMonthValue());
        sequencePattern.setEntity(entity);
        sequencePattern.setCurrentNumber(1);
        sequencePattern.setPattern(patternPrefix + "/|YYYY|/|MM|/|ID|");
        return sequencePattern;
    }

    @Override
    public SequencePattern findByYearAndMonthAndEntity(LocalDate sequenceDate, String entity) {
        Integer year = sequenceDate.getYear();
        Integer month = sequenceDate.getMonthValue();
        return sequencePatternRepository.findByYearAndMonthAndEntity(year, month, entity);
    }

    @Override
    public String getSequenceNumber(SequencePattern sequencePattern) {
        String pattern = sequencePattern.getPattern();
        String year = sequencePattern.getYear().toString();
        String month = sequencePattern.getMonth().toString();
        String currentNumber = sequencePattern.getCurrentNumber().toString();
        return pattern.replace("|YYYY|", year)
                .replace("|MM|", month)
                .replace("|ID|", currentNumber);
    }
}
