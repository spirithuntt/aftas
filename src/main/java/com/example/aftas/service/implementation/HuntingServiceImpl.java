package com.example.aftas.service.implementation;

import com.example.aftas.domain.Competition;
import com.example.aftas.domain.Fish;
import com.example.aftas.domain.Hunting;
import com.example.aftas.domain.Member;
import com.example.aftas.repository.HuntingRepository;
import com.example.aftas.service.CompetitionService;
import com.example.aftas.service.FishService;
import com.example.aftas.service.HuntingService;
import com.example.aftas.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HuntingServiceImpl implements HuntingService {

    private final HuntingRepository huntingRepository;
    private final FishService fishService;
    private final CompetitionService competitionService;
    private final MemberService memberService;

    @Override
    public Hunting save(Hunting hunting, Double weight) {
        hunting.setFish(fishService.getByName(hunting.getFish().getName()));
        if (weight >= hunting.getFish().getAverageWeight()){
            hunting.setCompetition(competitionService.getByCode(hunting.getCompetition().getCode()));
            hunting.setMember(memberService.getByNumber(hunting.getMember().getNumber()));
            Hunting existingHunt = checkIfFishAlreadyHunted(hunting.getMember(), hunting.getCompetition(), hunting.getFish());
            if(existingHunt == null){
                hunting.setNumberOfFish(1);
                return huntingRepository.save(hunting);
            }
            existingHunt.setNumberOfFish(existingHunt.getNumberOfFish() + 1);
            return huntingRepository.save(existingHunt);
        }
        return null;
    }

    @Override
    public List<Hunting> getAll() {
        return huntingRepository.findAll();
    }

    @Override
    public Hunting getById(Long id) {
        return huntingRepository.getHuntingsById(id);
    }

    @Override
    public List<Hunting> getByCompetition(String code) {
        return huntingRepository.getHuntingsByCompetition(competitionService.getByCode(code));
    }

    @Override
    public List<Hunting> getByMember(Integer member) {
        return huntingRepository.getHuntingsByMember(memberService.getByNumber(member));
    }

    @Override
    public List<Hunting> getByCompetitionAndMember(String competition, Integer member) {
        return huntingRepository.getHuntingsByCompetitionAndMember(competitionService.getByCode(competition), memberService.getByNumber(member));
    }

    @Override
    public Hunting update(Hunting hunting, Long id) {
        Hunting existingHunting = getById(id);
        if (existingHunting != null){
            existingHunting.setNumberOfFish(hunting.getNumberOfFish());
            return huntingRepository.save(existingHunting);
        }
        return null;
    }

    @Override
    public Hunting checkIfFishAlreadyHunted(Member member, Competition competition, Fish fish) {
        if (getAll().isEmpty()) return null;
        return getAll().stream().filter(hunting -> hunting.getMember().equals(member) && hunting.getCompetition().equals(competition) && hunting.getFish().equals(fish)).toList().get(0);
    }

    @Override
    public void delete(Long id) {
        Hunting hunting = getById(id);
        if (hunting != null) huntingRepository.delete(hunting);
    }
}
