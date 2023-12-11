package youcode.aftas.service;

import org.springframework.stereotype.Service;
import youcode.aftas.domain.Competition;

import java.util.Date;

@Service
public interface CompetitionService {
    String createCompetitionName(String location, String date);

    Boolean checkCompetitionDate(Date date);

    Competition createCompetition(Competition competition);

}
