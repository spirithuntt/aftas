package youcode.aftas.dto.responses;

import youcode.aftas.domain.Hunting;

public record HuntingResponseDTO(
        String fish,
        String member,
        String competition
) {
    public static HuntingResponseDTO fromHunting(Hunting hunting){
        return new HuntingResponseDTO(
                hunting.getFish() != null ? hunting.getFish().getName() : null,
                hunting.getMember() != null ? hunting.getMember().getIdentityNumber() : null,
                hunting.getCompetition() != null ? hunting.getCompetition().getCode() : null
        );
    }
}
