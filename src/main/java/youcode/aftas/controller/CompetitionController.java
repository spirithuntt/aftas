package youcode.aftas.controller;

import org.springframework.http.ResponseEntity;
import youcode.aftas.dto.requests.CompetitionRequestDTO;

public interface CompetitionController {
    ResponseEntity<?> getCompetitionById(Long id);

    ResponseEntity<?> getAllCompetitions();

    //createCompetition
    ResponseEntity<?> createCompetition(CompetitionRequestDTO competitionRequestDTO);

    ResponseEntity<?> updateCompetition(CompetitionRequestDTO competitionRequestDTO, Long id);

    ResponseEntity<?> deleteCompetition(Long id);
}
