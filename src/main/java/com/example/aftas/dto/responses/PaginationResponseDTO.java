package com.example.aftas.dto.responses;

import com.example.aftas.domain.Competition;
import com.example.aftas.domain.Member;

import java.util.List;

public record PaginationResponseDTO(
    int currentPage,
    int totalPages,
    Long totalCompetitions,
    List<CompetitionResponseDTO> competitions,
    int size
) {

//    public static PaginationResponseDTO fromCompetition(Competition competition){
//        return new MemberResponseDTO(
//                competition.getCode(),
//                competition.getDate(),
//                competition.getStartTime().format(timeFormatter),
//                competition.getEndTime().format(timeFormatter),
//                competition.getNumberOfParticipants(),
//                competition.getLocation(),
//                competition.getAmount()
//        );
}
