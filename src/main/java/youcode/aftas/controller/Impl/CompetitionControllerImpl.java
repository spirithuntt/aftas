package youcode.aftas.controller.Impl;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import youcode.aftas.controller.CompetitionController;
import youcode.aftas.domain.Competition;
import youcode.aftas.dto.requests.CompetitionRequestDTO;
import youcode.aftas.handler.response.ResponseMessage;
import youcode.aftas.service.CompetitionService;

import java.util.List;

@RestController
@RequestMapping("/api/competitions")
public class CompetitionControllerImpl implements CompetitionController{

    private CompetitionService competitionService;

    public CompetitionControllerImpl(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity getCompetitionById(@PathVariable Long id) {
        Competition competition = competitionService.getCompetitionById(id);
        if(competition == null) {
            return ResponseMessage.notFound("Competition not found");
        }else {
            return ResponseMessage.ok("Success", competition);
        }
    }

        @GetMapping
        public ResponseEntity getAllCompetitions() {
        List<Competition> competitions = competitionService.getAllCompetitions();
        if(competitions.isEmpty()) {
            return ResponseMessage.notFound("Competition not found");
        }else {
            return ResponseMessage.ok("Success", competitions);
        }
    }


    @PostMapping
    public ResponseEntity createCompetition(@Valid @RequestBody CompetitionRequestDTO competitionRequestDTO) {
        Competition competition1 = competitionService.createCompetition(competitionRequestDTO.toCompetition());
        if(competition1 == null) {
            return ResponseMessage.badRequest("Competition not created");
        }else {
            return ResponseMessage.created("Competition created successfully", competition1);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCompetition(@RequestBody CompetitionRequestDTO competitionRequestDTO, @PathVariable Long id) {
        Competition competition1 = competitionService.updateCompetition(competitionRequestDTO.toCompetition(), id);
        if(competition1 == null) {
            return ResponseMessage.badRequest("Competition not updated");
        }else {
            return ResponseMessage.created("Competition updated successfully", competition1);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCompetition(@PathVariable Long id) {
        Competition competition = competitionService.getCompetitionById(id);
        if(competition == null) {
            return ResponseMessage.notFound("Competition not found");
        }else {
            competitionService.deleteCompetition(id);
            return ResponseMessage.ok("Competition deleted successfully", null);
        }
    }

}
