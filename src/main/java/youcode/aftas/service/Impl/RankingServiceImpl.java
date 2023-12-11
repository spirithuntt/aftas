package youcode.aftas.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import youcode.aftas.domain.Competition;
import youcode.aftas.domain.Member;
import youcode.aftas.domain.Ranking;
import youcode.aftas.repository.RankingRepository;
import youcode.aftas.service.RankingService;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
@RequiredArgsConstructor
public class RankingServiceImpl implements RankingService {
    private final RankingRepository rankingRepository;

    @Override
    public void addPointsAndRank(Member member, Competition competition, int points, int numberOfFish){
        LocalDateTime competitionDate = competition.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime currentDate = LocalDateTime.now();

        if (!currentDate.toLocalDate().isEqual(competitionDate.toLocalDate())) {
            throw new RuntimeException("Results can only be saved on the same day as the competition");
        }

        Ranking ranking = rankingRepository.findByMemberAndCompetition(member, competition);
        if (ranking == null) {
            throw new RuntimeException("Ranking not found");
        }
        if (numberOfFish < 1) {
            throw new RuntimeException("Number of fish should be higher than 0");
        }

        ranking.setScore(ranking.getScore() + points * numberOfFish);
        ranking.setRank(calculateRank(member, competition));
        rankingRepository.save(ranking);
    }

    @Override
    public int calculateRank(Member member, Competition competition){
        Ranking ranking = rankingRepository.findByMemberAndCompetition(member, competition);
        if (ranking == null) {
            throw new RuntimeException("Ranking not found");
        }

        return rankingRepository.calculateRankForMember(member.getId(), competition.getId(), ranking.getScore());
    }

    @Override
    public void showPodium(Competition competition){
        if (competition == null) {
            throw new RuntimeException("Competition not found");
        }
        if (competition.getRankings().size() < 3) {
            throw new RuntimeException("Not enough rankings");
        }
        rankingRepository.findPodiumRankingsByCompetitionId(competition.getId());
    }

}
