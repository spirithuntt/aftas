package com.example.aftas.service;

import com.example.aftas.dto.requests.CompetitionRequestDTO;
import com.example.aftas.dto.responses.CompetitionResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CompetitionService {

    CompetitionResponseDTO save(CompetitionRequestDTO competition);

    List<CompetitionResponseDTO> getAll();

    CompetitionResponseDTO getById(Long id);

    CompetitionResponseDTO getByCode(String code);

    CompetitionResponseDTO update(CompetitionRequestDTO competition, Long id);

    void delete(Long id);

}
