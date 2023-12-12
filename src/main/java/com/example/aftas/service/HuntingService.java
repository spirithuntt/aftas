package com.example.aftas.service;

import com.example.aftas.domain.Competition;
import com.example.aftas.domain.Fish;
import com.example.aftas.domain.Hunting;
import com.example.aftas.domain.Member;
import com.example.aftas.dto.requests.HuntingRequestDTO;
import com.example.aftas.dto.responses.HuntingResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface HuntingService {

    HuntingResponseDTO save(HuntingRequestDTO hunting);

    List<HuntingResponseDTO> getAll();

    HuntingResponseDTO getById(Long id);

    List<HuntingResponseDTO> getByCompetition(String competition);

    List<HuntingResponseDTO> getByMember(String member);

    List<HuntingResponseDTO> getByCompetitionAndMember(String competition, String member);

    HuntingResponseDTO update(Hunting hunting, Long id);

    void checkIfFishAlreadyHunted(Member member, Competition competition, Fish fish);

    void delete(Long id);

}
