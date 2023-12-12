package com.example.aftas.dto.responses;

import com.example.aftas.domain.Ranking;

public record RankingResponseDTO(
    Integer rank,
    Integer score,
    Integer member,
    String competition
) {
    public static RankingResponseDTO fromRanking(Ranking ranking){
        return new RankingResponseDTO(
                ranking.getRank(),
                ranking.getScore(),
                ranking.getMember() != null ? ranking.getMember().getNumber() :null,
                ranking.getCompetition() != null ? ranking.getCompetition().getCode() : null
        );
    }
}
