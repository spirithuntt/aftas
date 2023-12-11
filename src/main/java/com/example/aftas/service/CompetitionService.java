package com.example.aftas.service;

import com.example.aftas.domain.Competition;
import com.example.aftas.domain.Member;
import com.example.aftas.domain.Ranking;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CompetitionService {

    Competition save(Competition competition);

    List<Competition> getAll();

    Competition getById(Long id);

    Competition update(Competition competition);

    void delete(Long id);

}
