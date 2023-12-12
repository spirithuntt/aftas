package com.example.aftas.service.implementation;

import com.example.aftas.domain.Ranking;
import com.example.aftas.dto.requests.RegisterMemberRequestDTO;
import com.example.aftas.dto.responses.RankingResponseDTO;
import com.example.aftas.service.RankingService;

import java.util.List;

public class RankingServiceImpl implements RankingService {
    @Override
    public RankingResponseDTO save(RegisterMemberRequestDTO ranking) {
        return null;
    }

    @Override
    public List<RankingResponseDTO> getAll() {
        return null;
    }

    @Override
    public RankingResponseDTO getById(Long id) {
        return null;
    }

    @Override
    public List<RankingResponseDTO> getByMember(String member) {
        return null;
    }

    @Override
    public List<RankingResponseDTO> getByCompetition(String competition) {
        return null;
    }

    @Override
    public RankingResponseDTO getByMemberAndCompetition(String member, String competition) {
        return null;
    }

    @Override
    public RankingResponseDTO update(Ranking ranking, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
