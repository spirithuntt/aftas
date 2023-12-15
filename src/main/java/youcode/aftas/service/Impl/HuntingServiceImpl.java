package youcode.aftas.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import youcode.aftas.domain.*;
import youcode.aftas.repository.HuntingRepository;
import youcode.aftas.service.*;

@Component
@RequiredArgsConstructor
public class HuntingServiceImpl implements HuntingService {
    private final HuntingRepository huntingRepository;
    private final FishService fishService;
    private final MemberService memberService;
    private final CompetitionService competitionService;
    private final RankingService rankingService;

    @Override
    public Hunting insertHunting(Hunting hunting, Double weight) {
        Long competitionId = hunting.getCompetition().getId();
        Long memberId = hunting.getMember().getId();
        Long fishId = hunting.getFish().getId();
        Competition competition = competitionService.getCompetitionById(competitionId);
        Member member = memberService.getMemberById(memberId);
        Fish fish = fishService.getFishById(fishId);
        if (rankingService.getRankingByCompetitionIdAndMemberId(competitionId, memberId) == null) {
            throw new RuntimeException("Member not found in this competition");
        }

        if (fish.getLevel() == null) {
            throw new RuntimeException("Fish must have level");
        }
        if (hunting.getFish().getAverageWeight() < fish.getAverageWeight()) {
            throw new RuntimeException("Weight of fish must be greater than average weight");
        }
        Hunting existingHunting = huntingRepository.findByCompetitionIdAndMemberIdAndFishId(competitionId, memberId, fishId);


        Ranking ranking = rankingService.getRankingByCompetitionIdAndMemberId(competitionId, memberId);
        if (ranking != null) {
            ranking.setScore(ranking.getScore() + fish.getLevel().getPoints());
            rankingService.updateRanking(ranking, ranking.getId());
        }
        else {
            ranking = new Ranking();
            ranking.setMember(member);
            ranking.setCompetition(competition);
            ranking.setScore(fish.getLevel().getPoints());
            ranking.setRank(rankingService.countByParticipantsId(competitionId) + 1);
            rankingService.updateRanking(ranking, ranking.getId());
        }
        ranking.setScore(ranking.getScore() + fish.getLevel().getPoints());
        rankingService.updateRanking(ranking, ranking.getId());

        if(existingHunting != null) {
            existingHunting.setNumberOfFish(existingHunting.getNumberOfFish() + 1);
            return huntingRepository.save(existingHunting);
        } else {
            hunting.setNumberOfFish(1);
            return huntingRepository.save(hunting);
        }
    }
    @Override
    public Hunting getHuntingById(Long id) {
        return huntingRepository.findById(id).orElseThrow(() -> new RuntimeException("Hunting not found"));
    }



    @Override
    public Hunting updateHunting(Hunting hunting, Long id) {
        Hunting existingHunting = getHuntingById(id);
        existingHunting.setFish(hunting.getFish());
        existingHunting.setMember(hunting.getMember());
        existingHunting.setCompetition(hunting.getCompetition());
        existingHunting.setNumberOfFish(hunting.getNumberOfFish());
        return huntingRepository.save(existingHunting);
    }

    @Override
    public void deleteHunting(Long id) {
        huntingRepository.deleteById(id);
    }
}
