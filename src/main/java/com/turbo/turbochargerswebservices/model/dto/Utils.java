package com.turbo.turbochargerswebservices.model.dto;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class Utils {
    private final String theFormat = "YYYY-MM-dd";
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(theFormat);

    public LocalDateTime asLocalDate(String string) {
        return LocalDateTime.parse(string, dateTimeFormatter);
    }

    public String asString(LocalDate localDate) {
        return localDate.format(dateTimeFormatter);
    }

}
