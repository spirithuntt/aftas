package com.example.aftas.service;

import com.example.aftas.domain.Competition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public interface CompetitionService {

    Competition save(Competition competition);

    Boolean checkDateAvailability(LocalDate date);

    String generateCode(LocalDate date, String location);

    List<Competition> getAll();

    Page<Competition> getAll(Pageable pageable);

    Competition getById(Long id);

    Competition getByCode(String code);

    Competition update(Competition competition, Long id);

    void delete(Long id);

}
