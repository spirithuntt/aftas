package com.example.aftas.service.implementation;

import com.example.aftas.domain.Competition;
import com.example.aftas.domain.Fish;
import com.example.aftas.domain.Hunting;
import com.example.aftas.domain.Member;
import com.example.aftas.dto.requests.HuntingRequestDTO;
import com.example.aftas.dto.responses.HuntingResponseDTO;
import com.example.aftas.service.HuntingService;

import java.util.List;

public class HuntingServiceImpl implements HuntingService {
    @Override
    public HuntingResponseDTO save(HuntingRequestDTO hunting) {
        return null;
    }

    @Override
    public List<HuntingResponseDTO> getAll() {
        return null;
    }

    @Override
    public HuntingResponseDTO getById(Long id) {
        return null;
    }

    @Override
    public List<HuntingResponseDTO> getByCompetition(String competition) {
        return null;
    }

    @Override
    public List<HuntingResponseDTO> getByMember(String member) {
        return null;
    }

    @Override
    public List<HuntingResponseDTO> getByCompetitionAndMember(String competition, String member) {
        return null;
    }

    @Override
    public HuntingResponseDTO update(Hunting hunting, Long id) {
        return null;
    }

    @Override
    public void checkIfFishAlreadyHunted(Member member, Competition competition, Fish fish) {

    }

    @Override
    public void delete(Long id) {

    }
}
