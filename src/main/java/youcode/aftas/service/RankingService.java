package youcode.aftas.service;

import org.springframework.stereotype.Service;
import youcode.aftas.domain.Competition;
import youcode.aftas.domain.Member;
import youcode.aftas.domain.RankId;
import youcode.aftas.domain.Ranking;
import youcode.aftas.dto.requests.RegistrationRequestDTO;
import youcode.aftas.dto.responses.RankingResponseDTO;

import java.util.List;

@Service
public interface RankingService {
    Ranking updateRanking(Ranking ranking, RankId id);

    List<Ranking> showPodium(Competition competition);

    int calculateRank(Member member, Competition competition);

    Ranking getRankingById(RankId id);

    void deleteRanking(Ranking ranking);

    int countByParticipantsId(Long competitionId);

    Integer countByCompetitionId(Long competitionId);

    Ranking getRankingByCompetitionIdAndMemberId(Long competitionId, Long memberId);
 }
