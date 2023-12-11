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

    Hunting update(Hunting hunting);

    void checkIfFishAlreadyHunted(Member member, Competition competition, Fish fish);

    void delete(Long id);

}
