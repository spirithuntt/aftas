package youcode.aftas.service.Impl;

import org.springframework.stereotype.Service;
import youcode.aftas.repository.CompetitionRepository;
import youcode.aftas.service.CompetitionService;

@Service
public class CompetitionServiceImpl implements CompetitionService {
    private final CompetitionRepository competitionRepository;

    public CompetitionServiceImpl(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }
    @Override
    public String createCompetitionName(String location, String date) {
        String competitionName = location.substring(0, 3) + date;
        return competitionName;
    }

    @Override
    public Boolean checkCompetitionDate(String date) {
        return competitionRepository.findByDate(date)!=null;
    }
}
