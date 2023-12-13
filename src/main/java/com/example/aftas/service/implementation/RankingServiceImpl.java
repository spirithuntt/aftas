package com.example.aftas.service.implementation;

import com.example.aftas.domain.Ranking;
import com.example.aftas.service.RankingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankingServiceImpl implements RankingService {
    @Override
    public Ranking save(Ranking ranking) {
        return null;
    }

    @Override
    public List<Ranking> getAll() {
        return null;
    }

    @Override
    public Ranking getById(Long id) {
        return null;
    }

    @Override
    public List<Ranking> getByMember(String member) {
        return null;
    }

    @Override
    public List<Ranking> getByCompetition(String competition) {
        return null;
    }

    @Override
    public Ranking getByMemberAndCompetition(String member, String competition) {
        return null;
    }

    @Override
    public Ranking update(Ranking ranking, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
