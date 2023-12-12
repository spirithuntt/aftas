package com.example.aftas.dto.responses;

import com.example.aftas.domain.Hunting;

public record HuntingResponseDTO(
    String fish,
    Integer member,
    String competition
) {
    public static HuntingResponseDTO fromHunting(Hunting hunting){
        return new HuntingResponseDTO(
                hunting.getFish() != null ? hunting.getFish().getName() : null,
                hunting.getMember() != null ? hunting.getMember().getNumber() : null,
                hunting.getCompetition() != null ? hunting.getCompetition().getCode() : null
        );
    }
}
