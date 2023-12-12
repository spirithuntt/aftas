package com.example.aftas.dto;

import com.example.aftas.domain.Competition;
import com.example.aftas.domain.Member;
import com.example.aftas.domain.Ranking;
import jakarta.persistence.ManyToOne;

public record RegisterMemberRequestDTO(
    Integer member,

    String competition
) {
    public Ranking toRanking() {
        return Ranking.builder()
                .competition(Competition.builder().code(competition).build())
                .member(Member.builder().number(member).build())
                .build();
    }
}
