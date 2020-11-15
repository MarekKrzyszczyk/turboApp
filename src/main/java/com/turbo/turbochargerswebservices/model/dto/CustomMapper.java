package com.turbo.turbochargerswebservices.model.dto;

import com.turbo.turbochargerswebservices.model.entity.Part;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomMapper {
    private final String THE_FORMAT = "YYYY-MM-dd";
    private final DateTimeFormatter DATETIMEFORMMATER = DateTimeFormatter.ofPattern(THE_FORMAT);

    public LocalDateTime asLocalDate(String string) {
        return LocalDateTime.parse(string, DATETIMEFORMMATER);
    }

    public String asString(LocalDate localDate) {
        return localDate.format(DATETIMEFORMMATER);
    }

    public List<String> partToPartName(List<Part> parts) {
        return parts.stream().map(Part::getName).collect(Collectors.toList());
    }
}
