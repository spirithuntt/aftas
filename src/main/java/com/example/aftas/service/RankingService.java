package com.example.aftas.service;

import com.example.aftas.domain.Competition;
import com.example.aftas.domain.Member;
import com.example.aftas.domain.Ranking;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RankingService {

    Ranking save(Ranking ranking);

    List<Ranking>getAll();

    Ranking getById(Long id);

    List<Ranking> getByMember(Member member);

    List<Ranking> getByCompetition(Competition competition);

    Ranking getByMemberAndCompetition(Member member, Competition competition);

    Ranking update(Ranking ranking, Long id);

    void delete(Long id);

}
