package youcode.aftas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import youcode.aftas.domain.Competition;
import youcode.aftas.domain.Member;
import youcode.aftas.domain.RankId;
import youcode.aftas.domain.Ranking;

import java.util.List;

@Repository
public interface RankingRepository extends JpaRepository<Ranking, RankId> {

    boolean existsByMemberAndCompetition(Member member, Competition competition);

    Ranking findByMemberAndCompetition(Member member, Competition competition);

    @Query("SELECT COUNT(r) + 1 FROM Ranking r WHERE r.member.id = :memberId AND r.competition.id = :competitionId AND r.score > :score")
    int calculateRankForMember(@Param("memberId") Long memberId, @Param("competitionId") Long competitionId, @Param("score") int score);

    List<Ranking> findTop3ByCompetitionIdOrderByScoreDesc(Long competitionId);


    @Query("SELECT COUNT(r) FROM Ranking r WHERE r.competition.id = :competitionId")
    int countByParticipantsId(@Param("competitionId") Long competitionId);

    Ranking findByMemberIdAndCompetitionId(Long memberId, Long competitionId);

    Integer countByCompetitionId(Long competitionId);

    Ranking getRankingByCompetitionIdAndMemberId(Long competitionId, Long memberId);

    @Query("SELECT COUNT(r) FROM Ranking r")
    int countByNumberOfParticipants();
}