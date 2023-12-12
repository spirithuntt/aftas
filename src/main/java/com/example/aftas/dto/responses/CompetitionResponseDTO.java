package com.example.aftas.dto.responses;

import com.example.aftas.domain.Competition;

import java.time.LocalDate;
import java.time.LocalTime;

public record CompetitionResponseDTO(
        String code,
        LocalDate date,
        LocalTime startTime,
        LocalTime endTime,
        Integer numberOfParticipants,
        String location,
        Double amount
) {
    public static CompetitionResponseDTO fromCompetition(Competition competition) {
        return new CompetitionResponseDTO(
                competition.getCode(),
                competition.getDate(),
                competition.getStartTime(),
                competition.getEndTime(),
                competition.getNumberOfParticipants(),
                competition.getLocation(),
                competition.getAmount()
        );
    }
}
