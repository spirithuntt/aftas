package youcode.aftas.service;

import org.springframework.stereotype.Service;
import youcode.aftas.domain.Competition;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public interface CompetitionService {
    String createCompetitionName(String location, String date);

    Boolean checkCompetitionDate(Date date);

    Competition createCompetition(Competition competition);

    Competition getCompetitionById(Long id);

    Competition updateCompetition(Competition competition, Long id);

    void deleteCompetition(Long id);

    List<Competition> getAllCompetitions();

    Boolean isCompetitionAvailableForRegistration(Long id);

}
