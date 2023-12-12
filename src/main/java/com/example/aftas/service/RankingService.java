package com.example.aftas.service;

import com.example.aftas.domain.Competition;
import com.example.aftas.domain.Member;
import com.example.aftas.domain.Ranking;
import com.example.aftas.dto.requests.RegisterMemberRequestDTO;
import com.example.aftas.dto.responses.RankingResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RankingService {

    RankingService save(RegisterMemberRequestDTO ranking);

    List<RankingResponseDTO>getAll();

    RankingResponseDTO getById(Long id);

    List<RankingResponseDTO> getByMember(String member);

    List<RankingResponseDTO> getByCompetition(String competition);

    RankingResponseDTO getByMemberAndCompetition(String member, String competition);

    RankingResponseDTO update(Ranking ranking, Long id);

    void delete(Long id);

}
