package youcode.aftas.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import youcode.aftas.repository.CompetitionRepository;
import youcode.aftas.service.CompetitionService;

@Component
@RequiredArgsConstructor
public class CompetitionServiceImpl implements CompetitionService {
    private final CompetitionRepository competitionRepository;
    @Override
    public String createCompetitionName(String location, String date) {
        return location.substring(0, 3) + date;
    }

    @Override
    public Boolean checkCompetitionDate(String date) {
        return competitionRepository.findByDate(date)!=null;
    }
}
