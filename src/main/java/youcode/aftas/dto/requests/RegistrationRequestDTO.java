package youcode.aftas.dto.requests;

import youcode.aftas.domain.Competition;
import youcode.aftas.domain.Member;
import youcode.aftas.domain.Ranking;

public record RegistrationRequestDTO(
        Member member,
        Competition competition
)
{
    public Ranking toRanking() {
        return Ranking.builder()
                .member(member)
                .competition(competition)
                .build();
    }
}
