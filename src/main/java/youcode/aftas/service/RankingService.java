package youcode.aftas.service;

import org.springframework.stereotype.Service;
import youcode.aftas.domain.Competition;
import youcode.aftas.domain.Member;

@Service
public interface RankingService {
     void addPointsAndRank(Member member, Competition competition, int points, int numberOfFish);

    void showPodium(Competition competition);

    int calculateRank(Member member, Competition competition);

}
