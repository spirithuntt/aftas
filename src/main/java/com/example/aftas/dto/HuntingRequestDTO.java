package com.example.aftas.dto;

import com.example.aftas.domain.Competition;
import com.example.aftas.domain.Fish;
import com.example.aftas.domain.Hunting;
import com.example.aftas.domain.Member;
import jakarta.persistence.ManyToOne;

public record HuntingRequestDTO(
        String fish,

        Integer member,

        String competition
) {
    public Hunting toHunting() {
        return Hunting.builder()
                .competition(Competition.builder().code(competition).build())
                .member(Member.builder().number(member).build())
                .fish(Fish.builder().name(fish).build())
                .build();
    }
}
