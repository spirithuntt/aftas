package com.example.aftas.service.implementation;

import com.example.aftas.dto.requests.CompetitionRequestDTO;
import com.example.aftas.dto.responses.CompetitionResponseDTO;
import com.example.aftas.service.CompetitionService;

import java.util.List;

public class CompetitionServiceImpl implements CompetitionService {
    @Override
    public CompetitionResponseDTO save(CompetitionRequestDTO competition) {
        return null;
    }

    @Override
    public List<CompetitionResponseDTO> getAll() {
        return null;
    }

    @Override
    public CompetitionResponseDTO getById(Long id) {
        return null;
    }

    @Override
    public CompetitionResponseDTO getByCode(String code) {
        return null;
    }

    @Override
    public CompetitionResponseDTO update(CompetitionRequestDTO competition, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
