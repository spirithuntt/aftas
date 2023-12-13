package com.example.aftas.service.implementation;

import com.example.aftas.domain.Competition;
import com.example.aftas.domain.Fish;
import com.example.aftas.domain.Hunting;
import com.example.aftas.domain.Member;
import com.example.aftas.repository.HuntingRepository;
import com.example.aftas.service.FishService;
import com.example.aftas.service.HuntingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HuntingServiceImpl implements HuntingService {

    private final HuntingRepository huntingRepository;
    private final FishService fishService;
    @Override
    public Hunting save(Hunting hunting) {
        System.out.println("hh");

        Hunting existingHunt = checkIfFishAlreadyHunted(hunting.getMember(), hunting.getCompetition(), hunting.getFish());
        if(existingHunt == null){
            return huntingRepository.save(hunting);
        }
        existingHunt.setNumberOfFish(existingHunt.getNumberOfFish() + 1);
        return huntingRepository.save(existingHunt);
    }

    @Override
    public List<Hunting> getAll() {
        return huntingRepository.findAll();
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
    public Hunting checkIfFishAlreadyHunted(Member member, Competition competition, Fish fish) {
        List<Hunting> hunts = getAll().stream().filter(hunting -> hunting.getMember().equals(member) && hunting.getCompetition().equals(competition) && hunting.getFish().equals(fish)).toList();
        System.out.println("cc");
        if(hunts.isEmpty()) return null;
        return hunts.get(0);
    }

    @Override
    public void delete(Long id) {

    }
}
