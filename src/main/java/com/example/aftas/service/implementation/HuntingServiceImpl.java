package com.example.aftas.service.implementation;

import com.example.aftas.domain.Competition;
import com.example.aftas.domain.Fish;
import com.example.aftas.domain.Hunting;
import com.example.aftas.domain.Member;
import com.example.aftas.service.HuntingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HuntingServiceImpl implements HuntingService {
    @Override
    public Hunting save(Hunting hunting) {
        return null;
    }

    @Override
    public List<Hunting> getAll() {
        return null;
    }

    @Override
    public Hunting getById(Long id) {
        return null;
    }

    @Override
    public List<Hunting> getByCompetition(String competition) {
        return null;
    }

    @Override
    public List<Hunting> getByMember(String member) {
        return null;
    }

    @Override
    public List<Hunting> getByCompetitionAndMember(String competition, String member) {
        return null;
    }

    @Override
    public Hunting update(Hunting hunting, Long id) {
        return null;
    }

    @Override
    public void checkIfFishAlreadyHunted(Member member, Competition competition, Fish fish) {

    }

    @Override
    public void delete(Long id) {

    }
}
