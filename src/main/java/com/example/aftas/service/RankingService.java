package com.example.aftas.service;

import com.example.aftas.domain.Competition;
import com.example.aftas.domain.Member;
import com.example.aftas.domain.RankId;
import com.example.aftas.domain.Ranking;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RankingService {

    Ranking save(Ranking ranking);

    List<Ranking> getAll();

    Ranking getById(RankId id);

    List<Ranking> getByMember(Integer member);

    List<Ranking> getByCompetition(String competition);

    Ranking getByMemberAndCompetition(Integer member, String competition);

    Ranking update(Ranking ranking);

    List<Ranking> sortParticipantsByScore(String competition);

    void delete(Ranking ranking);

    List<Competition> getCompetitionsByMemberId(Long memberId);

    List<Competition> getRankingByMemberEmail(String email);
}
