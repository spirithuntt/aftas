package com.example.aftas.dto.responses;

import com.example.aftas.domain.Competition;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public record CompetitionResponseDTO(
        String code,
        LocalDate date,
        String startTime,
        String endTime,
        Integer numberOfParticipants,
        String location,
        Double amount
) {
    public static CompetitionResponseDTO fromCompetition(Competition competition) {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        return new CompetitionResponseDTO(
                competition.getCode(),
                competition.getDate(),
                competition.getStartTime().format(timeFormatter),
                competition.getEndTime().format(timeFormatter),
                competition.getNumberOfParticipants(),
                competition.getLocation(),
                competition.getAmount()
        );
    }
}
