package youcode.aftas.controller.Impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import youcode.aftas.controller.RankingController;
import youcode.aftas.domain.Ranking;
import youcode.aftas.service.RankingService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import youcode.aftas.domain.Member;
import youcode.aftas.handler.response.ResponseMessage;

@RestController
@RequestMapping("/api/rankings")
public class RankingControllerImpl implements RankingController {
    private final RankingService rankingService;

    public RankingControllerImpl(RankingService rankingService) {
        this.rankingService = rankingService;
    }

    // get ranking by id
    @GetMapping
    public ResponseEntity getRankingById(@PathVariable Long id) {
        Ranking ranking = rankingService.getRankingById(id);
        return ResponseMessage.ok("Success", ranking);
    }

    // get ranking by member id and competition id
    @GetMapping("/{competitionId}/{memberId}")
    public ResponseEntity getRankingsByMemberIdAndCompetitionId(@PathVariable Long competitionId, @PathVariable Long memberId) {
        Ranking ranking = rankingService.getRankingsByMemberIdAndCompetitionId(competitionId, memberId);
        return ResponseMessage.ok("Success", ranking);
    }

//TO DO : // update ranking

    // delete ranking
    @DeleteMapping("/{id}")
    public ResponseEntity deleteRanking(@PathVariable Long id) {
        rankingService.deleteRanking(id);
        return ResponseMessage.ok("Ranking deleted successfully", null);
    }
}
