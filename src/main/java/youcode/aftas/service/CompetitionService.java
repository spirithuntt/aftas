package youcode.aftas.service;

public interface CompetitionService {
    String createCompetitionName(String location, String date);

    Boolean checkCompetitionDate(String date);
}
