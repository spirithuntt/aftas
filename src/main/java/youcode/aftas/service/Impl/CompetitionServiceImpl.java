package youcode.aftas.service.Impl;

import org.springframework.stereotype.Component;
import youcode.aftas.domain.Competition;
import youcode.aftas.repository.CompetitionRepository;
import youcode.aftas.service.CompetitionService;
import youcode.aftas.service.RankingService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class CompetitionServiceImpl implements CompetitionService {
    private final CompetitionRepository competitionRepository;
    private final RankingService rankingService;

    public CompetitionServiceImpl(CompetitionRepository competitionRepository, RankingService rankingService) {
        this.competitionRepository = competitionRepository;
        this.rankingService = rankingService;
    }

    @Override
    public String createCompetitionName(String location, String date) {
            SimpleDateFormat input = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
            SimpleDateFormat output = new SimpleDateFormat("yy-MM-dd");

            try {
                Date parsedDate = input.parse(date);
                String FormattedDate = output.format(parsedDate);
                String[] dateParts = FormattedDate.split("-");

                if (dateParts.length < 3) {
                    throw new RuntimeException("Unexpected date format");
                }

                String day = dateParts[2];
                String month = dateParts[1];
                String year = dateParts[0];

                String abbreviatedLocation = location.substring(0, Math.min(location.length(), 3));

                return abbreviatedLocation.toLowerCase() + "-" + day + "-" + month + "-" + year;

            } catch (ParseException e) {
                throw new RuntimeException("Error parsing date", e);
            }
        }


    @Override
    public Boolean checkCompetitionDate(Date date) {
        List<Competition> competitions = competitionRepository.findByDate(date);
        return !competitions.isEmpty();
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
    @Override
    public Competition getCompetitionById(Long id) {
        return competitionRepository.findById(id).orElse(null);
    }

    @Override
    public Competition updateCompetition(Competition competition, Long id) {
            return null;
    }

    @Override
    public void deleteCompetition(Long id) {
        competitionRepository.deleteById(id);
    }
    @Override
    public List<Competition> getAllCompetitions() {
        return competitionRepository.findAll();
    }

    @Override
    public Boolean isCompetitionAvailableForRegistration(Long id) {
        Optional<Competition> optionalCompetition = competitionRepository.findById(id);
        if(optionalCompetition.isPresent()){
            Competition competition = optionalCompetition.get();
            LocalDate registrationDate = competition.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().minusDays(1);
            if(LocalDate.now().isAfter(registrationDate)){
                throw new IllegalArgumentException("Invalid date");
            }

            if(rankingService.countByCompetitionId(competition.getId())>competition.getNumberOfParticipants()){
                throw new IllegalArgumentException("competition is full");
            }
            return true;

        }
        return false;
    }



}
