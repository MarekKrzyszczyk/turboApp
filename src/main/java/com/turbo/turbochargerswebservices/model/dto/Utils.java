package com.turbo.turbochargerswebservices.model.dto;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class Utils {
    private final String THE_FORMAT = "YYYY-MM-dd";
    private final DateTimeFormatter DATETIMEFORMMATER = DateTimeFormatter.ofPattern(THE_FORMAT);

    public LocalDateTime asLocalDate(String string) {
        return LocalDateTime.parse(string, DATETIMEFORMMATER);
    }

    public String asString(LocalDate localDate) {
        return localDate.format(DATETIMEFORMMATER);
    }

}
