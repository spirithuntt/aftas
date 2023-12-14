package youcode.aftas.dto.requests;

import jakarta.validation.constraints.NotNull;
import youcode.aftas.domain.Competition;
import youcode.aftas.domain.Member;
import youcode.aftas.domain.Ranking;

public record RegistrationRequestDTO(

        @NotNull
        Long member,
        @NotNull
        Long competition
)
{
    public Ranking toRanking() {
        return Ranking.builder()
                .competition(Competition.builder().id(competition).build())
                .member(Member.builder().id(member).build())
                .build();
    }
}
