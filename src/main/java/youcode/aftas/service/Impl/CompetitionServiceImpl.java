package youcode.aftas.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import youcode.aftas.domain.Competition;
import youcode.aftas.repository.CompetitionRepository;
import youcode.aftas.service.CompetitionService;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class CompetitionServiceImpl implements CompetitionService {
    private final CompetitionRepository competitionRepository;
    @Override
    public String createCompetitionName(String location, String date) {
        return location.substring(0, 3) + date;
    }

    @Override
    public Boolean checkCompetitionDate(Date date) {
        return competitionRepository.findByDate(date)!=null;
    }
    @Override
    public Competition createCompetition(Competition competition) {
        String competitionName = createCompetitionName(competition.getLocation(), competition.getDate().toString());
        if (checkCompetitionDate(competition.getDate())) {
            throw new RuntimeException("Competition already exist");
        }
        competition.setCode(competitionName);
        return competitionRepository.save(competition);
    }


}
