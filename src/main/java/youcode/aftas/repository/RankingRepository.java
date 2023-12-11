package youcode.aftas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import youcode.aftas.domain.Competition;
import youcode.aftas.domain.Member;
import youcode.aftas.domain.Ranking;

@Repository
public interface RankingRepository extends JpaRepository<Ranking, Long>{

    boolean existsByMemberAndCompetition(Member member, Competition competition);
}
