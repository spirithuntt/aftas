package com.example.aftas.repository;

import com.example.aftas.domain.Competition;
import com.example.aftas.domain.Member;
import com.example.aftas.domain.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RankingRepository extends JpaRepository<Ranking, Long> {

    Ranking getRankingById(Long id);

    List<Ranking> getRankingByMember(Member member);

    List<Ranking> getRankingByCompetition(Competition competition);

    Ranking getRankingByMemberAndCompetition(Member member, Competition competition);

}