package youcode.aftas.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import youcode.aftas.domain.Competition;
import youcode.aftas.domain.RankId;
import youcode.aftas.domain.Ranking;
import youcode.aftas.dto.requests.RegistrationRequestDTO;
import youcode.aftas.dto.responses.RankingResponseDTO;
import youcode.aftas.service.CompetitionService;
import youcode.aftas.service.RankingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import youcode.aftas.handler.response.ResponseMessage;
import java.util.List;

@RestController
@RequestMapping("/api/rankings")
@RequiredArgsConstructor
public class RankingController {
    private final RankingService rankingService;
    private final CompetitionService competitionService;



    // get ranking by id
    @GetMapping
    public ResponseEntity getRankingById(@PathVariable RankId id) {
        Ranking ranking = rankingService.getRankingById(id);
        return ResponseMessage.ok("Success", ranking);
    }

    // get ranking by member id and competition id
    @GetMapping("/{competitionId}/{memberId}")
    public ResponseEntity getRankingsByMemberIdAndCompetitionId(@PathVariable Long competitionId, @PathVariable Long memberId) {
        Ranking ranking = rankingService.getRankingByCompetitionIdAndMemberId(competitionId, memberId);
        return ResponseMessage.ok("Success", ranking);
    }

//TO DO : // update ranking

    // delete ranking
    @DeleteMapping("/{id}")
    public ResponseEntity deleteRanking(@PathVariable RankId id) {
        Ranking ranking = rankingService.getRankingById(id);
        rankingService.deleteRanking(ranking);
        return ResponseMessage.ok("Ranking deleted successfully", null);
    }

    @GetMapping("/podium/{competitionId}")
    public ResponseEntity getPodium(@PathVariable Long competitionId) {
        Competition competition1 = competitionService.getCompetitionById(competitionId);
                List<Ranking> podium = rankingService.showPodium(competition1);
        return ResponseMessage.ok("Podium retrieved successfully", podium);
    }


}

