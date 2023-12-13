package youcode.aftas.service;

import org.springframework.stereotype.Service;
import youcode.aftas.domain.Competition;
import youcode.aftas.domain.Member;
import youcode.aftas.domain.Ranking;

@Service
public interface RankingService {
     void addPointsAndRank(Member member, Competition competition, int points, int numberOfFish);

    void showPodium(Competition competition);

    int calculateRank(Member member, Competition competition);

    Ranking getRankingById(Long id);

    Ranking getRankingsByMemberIdAndCompetitionId(Long memberId, Long competitionId);

    void deleteRanking(Long id);


}
