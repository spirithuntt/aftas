package youcode.aftas.dto.responses;

import youcode.aftas.domain.Ranking;

public record RankingResponseDTO(
        Integer rank,
        Integer score,
        String member,
        String competition
) {
    public static RankingResponseDTO fromRanking(Ranking ranking){
        return new RankingResponseDTO(
                ranking.getRank(),
                ranking.getScore(),
                ranking.getMember() != null ? ranking.getMember().getIdentityNumber() : null,
                ranking.getCompetition() != null ? ranking.getCompetition().getCode() : null
        );
    }
}
