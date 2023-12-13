package com.example.aftas.dto.requests;

import com.example.aftas.domain.Competition;
import com.example.aftas.domain.Fish;
import com.example.aftas.domain.Hunting;
import com.example.aftas.domain.Member;

public record UpdateHuntingRequestDTO(
        Integer numberOfFish
) {
    public Hunting toHunting() {
        return Hunting.builder()
                .numberOfFish(numberOfFish)
                .build();
    }
}
