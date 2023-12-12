package com.example.aftas.dto.requests;

import com.example.aftas.domain.Competition;
import com.example.aftas.domain.Member;
import com.example.aftas.domain.Ranking;

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
