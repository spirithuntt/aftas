package com.example.aftas.repository;

import com.example.aftas.domain.Competition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetitionRepository {

    Competition save(Competition competition);

    List<Competition> getAll();

    Competition getById(Long id);

    Competition update(Competition competition);

    void delete(Long id);
}