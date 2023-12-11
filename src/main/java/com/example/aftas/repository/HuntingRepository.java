package com.example.aftas.repository;

import com.example.aftas.domain.Competition;
import com.example.aftas.domain.Fish;
import com.example.aftas.domain.Hunting;
import com.example.aftas.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HuntingRepository extends JpaRepository<Hunting, Long> {

    Hunting getHuntingsById(Long id);

    List<Hunting> getHuntingsByCompetition(Competition competition);

    List<Hunting> getHuntingsByMember(Member member);

    List<Hunting> getHuntingsByCompetitionAndMember(Competition competition, Member member);

}
