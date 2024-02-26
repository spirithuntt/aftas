package com.example.aftas.repository;

import com.example.aftas.domain.Competition;
import com.example.aftas.domain.Member;
import com.example.aftas.domain.RankId;
import com.example.aftas.domain.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankingRepository extends JpaRepository<Ranking, RankId> {

//    Ranking getRankingById(Long id);

    List<Ranking> getRankingByMemberId(Long memberId);

    List<Ranking> getRankingByMemberEmail(String email);
    List<Ranking> getRankingByCompetition(Competition competition);

    Ranking getRankingByMemberAndCompetition(Member member, Competition competition);



}