package com.example.aftas.service;

import com.example.aftas.domain.Competition;
import com.example.aftas.domain.Fish;
import com.example.aftas.domain.Hunting;
import com.example.aftas.domain.Member;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface HuntingService {

    Hunting save(Hunting hunting);

    List<Hunting> getAll();

    Hunting getById(Long id);

    List<Hunting> getByCompetition(String competition);

    List<Hunting> getByMember(String member);

    List<Hunting> getByCompetitionAndMember(String competition, String member);

    Hunting update(Hunting hunting, Long id);

    Hunting checkIfFishAlreadyHunted(Member member, Competition competition, Fish fish);

    void delete(Long id);

}
