package youcode.aftas.dto.requests;

import jakarta.validation.constraints.NotNull;
import youcode.aftas.domain.Fish;
import youcode.aftas.domain.Hunting;
import youcode.aftas.domain.Member;

public record HuntingRequestDTO(
        @NotNull(message = "Code can not be null")
        Integer numberOfFish,
        @NotNull(message = "Code can not be null")
        Member member,
        @NotNull(message = "Code can not be null")
        Fish fish
){
            public Hunting toHunting() {
                Hunting.HuntingBuilder huntingBuilder = new Hunting().builder()
                        .numberOfFish(numberOfFish);
                return huntingBuilder.build();
            }
}