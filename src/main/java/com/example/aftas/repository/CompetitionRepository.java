package com.example.aftas.repository;

import com.example.aftas.domain.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Long> {

    Competition getCompetitionById(Long id);

    Competition getCompetitionByCode(String code);

    Competition getCompetitionByDate(LocalDate date);

}