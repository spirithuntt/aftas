package youcode.aftas.service;

import org.springframework.stereotype.Service;
import youcode.aftas.domain.Competition;
import youcode.aftas.domain.Member;
import youcode.aftas.domain.RankId;
import youcode.aftas.domain.Ranking;
import youcode.aftas.dto.requests.RegistrationRequestDTO;
import youcode.aftas.dto.responses.RankingResponseDTO;

@Service
public interface RankingService {
     void addPointsAndRank(Member member, Competition competition, int points, int numberOfFish);

    void showPodium(Competition competition);

    int calculateRank(Member member, Competition competition);

    Ranking getRankingById(RankId id);

    Ranking getRankingsByMemberIdAndCompetitionId(Long memberId, Long competitionId);

    void deleteRanking(Ranking ranking);

    boolean isRegistrationAllowed(Member member, Competition competition);

    boolean isUserAlreadyRegistered(Member member, Competition competition);

    int countByParticipantsId(Long competitionId);

    Integer countByCompetitionId(Long competitionId);

    Ranking getRankingByCompetitionIdAndMemberId(Long competitionId, Long memberId);




}
