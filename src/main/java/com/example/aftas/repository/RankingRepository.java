package com.example.aftas.repository;

import com.example.aftas.domain.Competition;
import com.example.aftas.domain.Member;
import com.example.aftas.domain.Ranking;

import java.util.List;

public interface RankingRepository {

    Ranking save(Ranking ranking);

    List<Ranking> getAll();

    Ranking getById(Long id);

    List<Ranking> getByMemberRankings(Member member);

    List<Ranking> getByCompetitionRankings(Competition competition);

    Ranking getByMemberAndCompetitionRanking(Member member, Competition competition);

    Ranking update(Ranking ranking);

    void delete(Long id);

}