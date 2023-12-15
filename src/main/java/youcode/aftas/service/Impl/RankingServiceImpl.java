package youcode.aftas.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import youcode.aftas.domain.Competition;
import youcode.aftas.domain.Member;
import youcode.aftas.domain.RankId;
import youcode.aftas.domain.Ranking;
import youcode.aftas.repository.RankingRepository;
import youcode.aftas.service.MemberService;
import youcode.aftas.service.RankingService;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RankingServiceImpl implements RankingService {
    private  final RankingRepository rankingRepository;
    private  final MemberService memberService;


    @Override
    public int calculateRank(Member member, Competition competition){
        Ranking ranking = rankingRepository.findByMemberAndCompetition(member, competition);
        if (ranking == null) {
            throw new RuntimeException("Ranking not found");
        }

        return rankingRepository.calculateRankForMember(competition.getId(), member.getId(), ranking.getScore());
    }

    @Override
    public Ranking getRankingById(RankId id) {
        return rankingRepository.findById(id).orElseThrow(() -> new RuntimeException("Ranking not found"));
    }


    @Override
    public void deleteRanking(Ranking ranking) {
        rankingRepository.delete(ranking);
    }

        @Override
        public int countByParticipantsId(Long competitionId) {
            return rankingRepository.countByParticipantsId(competitionId);
        }

    @Override
    public Integer countByCompetitionId(Long competitionId) {
        return rankingRepository.countByCompetitionId(competitionId);
    }
    @Override
    public Ranking getRankingByCompetitionIdAndMemberId(Long competitionId, Long memberId) {
        return rankingRepository.getRankingByCompetitionIdAndMemberId(competitionId, memberId);
    }

    @Override
    public Ranking updateRanking(Ranking ranking, RankId id) {
        Ranking existingRanking = getRankingById(id);
        if (existingRanking == null) {
            throw new RuntimeException("Ranking not found");
        }
        else {
            existingRanking.setRank(calculateRank(existingRanking.getMember(), existingRanking.getCompetition()));
            existingRanking.setScore(ranking.getScore());
            return rankingRepository.save(existingRanking);
        }
    }


    @Override
    public List<Ranking> showPodium(Competition competition) {
        if (competition == null) {
            throw new IllegalArgumentException("Competition not found");
        }

        return rankingRepository.findTop3ByCompetitionIdOrderByScoreDesc(competition.getId());
    }

}



