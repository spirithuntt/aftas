package youcode.aftas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Controller
public interface RankingController {
    ResponseEntity<?> getRankingById(Long id);

    ResponseEntity<?> getRankingsByMemberIdAndCompetitionId(Long memberId, Long competitionId);

    ResponseEntity<?> deleteRanking(Long id);


}
