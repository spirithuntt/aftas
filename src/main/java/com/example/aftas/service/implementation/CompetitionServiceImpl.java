package com.example.aftas.service.implementation;

import com.example.aftas.domain.Competition;
import com.example.aftas.repository.CompetitionRepository;
import com.example.aftas.service.CompetitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompetitionServiceImpl implements CompetitionService {

    private final CompetitionRepository competitionRepository;

    @Override
    public Competition save(Competition competition) {
        if (checkDateAvailability(competition.getDate())){
            competition.setCode(generateCode(competition.getDate(), competition.getLocation()));
            return competitionRepository.save(competition);
        }
        else return null;
    }

    @Override
    public Boolean checkDateAvailability(LocalDate date){
        List<Competition> existingCompetitions = getAll().stream().filter(existingCompetition -> existingCompetition.getDate().equals(date)).toList();
        return date.isAfter(LocalDate.now()) && existingCompetitions.isEmpty();
    }

    @Override
    public String generateCode(LocalDate date, String location){
        return location.substring(0,3).toLowerCase() + "-" + date.toString().substring(8,10) + "-" + date.toString().substring(5,7) + "-" + date.toString().substring(2,4);
    }

    @Override
    public List<Competition> getAll() {
        return competitionRepository.findAll();
    }

    @Override
    public Competition getById(Long id) {
        return competitionRepository.getCompetitionById(id);
    }

    @Override
    public Competition getByCode(String code) {
        return competitionRepository.getCompetitionByCode(code);
    }

    @Override
    public Competition update(Competition competition, Long id) {
        Competition existingCompetition = competitionRepository.getCompetitionById(id);
        if (existingCompetition != null){
            existingCompetition.setAmount(competition.getAmount());
            existingCompetition.setEndTime(competition.getEndTime());
            existingCompetition.setStartTime(competition.getStartTime());
            existingCompetition.setNumberOfParticipants(competition.getNumberOfParticipants());
            if(checkDateAvailability(competition.getDate())){
                existingCompetition.setDate(competition.getDate());
                existingCompetition.setCode(generateCode(competition.getDate(), competition.getLocation()));
            }
            return competitionRepository.save(existingCompetition);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        Competition competition = competitionRepository.getCompetitionById(id);
        if (competition != null) competitionRepository.delete(competition);
    }
}
