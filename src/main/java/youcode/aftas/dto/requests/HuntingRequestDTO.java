package youcode.aftas.dto.requests;

import jakarta.validation.constraints.NotNull;
import youcode.aftas.domain.Competition;
import youcode.aftas.domain.Fish;
import youcode.aftas.domain.Hunting;
import youcode.aftas.domain.Member;

public record HuntingRequestDTO(
        @NotNull(message = "member can not be null")
        Long member,
        @NotNull(message = "fish can not be null")
        Long fish,
        @NotNull(message = "competition can not be null")
        Long competition,

        @NotNull(message = "weight can not be null")
        Double weight

){
    public Hunting toHunting() {
        return Hunting.builder()
                .competition(Competition.builder().id(competition).build())
                .member(Member.builder().id(member).build())
                .fish(Fish.builder().id(fish)
                        .averageWeight(weight)
                        .build())
                .build();
    }
}