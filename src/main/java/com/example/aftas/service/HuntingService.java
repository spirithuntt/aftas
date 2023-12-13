package com.example.aftas.service;

import com.example.aftas.domain.Competition;
import com.example.aftas.domain.Fish;
import com.example.aftas.domain.Hunting;
import com.example.aftas.domain.Member;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface HuntingService {

    Hunting save(Hunting hunting, Double weight);

    List<Hunting> getAll();

    Hunting getById(Long id);

    List<Hunting> getByCompetition(String code);

    List<Hunting> getByMember(Integer member);

    List<Hunting> getByCompetitionAndMember(String competition, Integer member);

    Hunting update(Hunting hunting, Long id);

    Hunting checkIfFishAlreadyHunted(Member member, Competition competition, Fish fish);

    void delete(Long id);

}
