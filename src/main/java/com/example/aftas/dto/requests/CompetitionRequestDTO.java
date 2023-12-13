package com.example.aftas.dto.requests;

import com.example.aftas.domain.Competition;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public record CompetitionRequestDTO(

        @NotNull(message = "Date shouldn't be null")
        @Future
        @DateTimeFormat(pattern = "yyyy-mm-dd")
        LocalDate date,

        @NotNull(message = "Time shouldn't be null")
        @DateTimeFormat(pattern = "hh:mm:ss")
        LocalTime startTime,

        @NotNull(message = "Time shouldn't be null")
        @DateTimeFormat(pattern = "hh:mm:ss")
        LocalTime endTime,

        @NotNull(message = "Number of participants shouldn't be null")
        @Range(min = 1, message = "Number of participants must be greater than 1")
        Integer numberOfParticipants,

        @NotNull(message = "Location shouldn't be null")
        @NotBlank(message = "Location shouldn't be blank")
        @Size(min = 2, max = 100, message = "Location must be between 2 and 100 characters")
        String location,

        @NotNull(message = "Amount shouldn't be null")
//        @NotBlank(message = "Amount shouldn't be blank")
        @Range(min = 0, message = "Amount must be greater than 0")
        Double amount
) {
    public Competition toCompetition(){
        Competition.CompetitionBuilder competitionBuilder = new Competition().builder()
                .date(date)
                .startTime(startTime)
                .endTime(endTime)
                .numberOfParticipants(numberOfParticipants)
                .location(location)
                .amount(amount);
        return competitionBuilder.build();
    }

}
