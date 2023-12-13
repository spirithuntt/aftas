package youcode.aftas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import youcode.aftas.domain.Hunting;

@Repository
public interface HuntingRepository extends JpaRepository<Hunting, Long>{
    Hunting findByFishIdAndMemberId(Long fishId, Long memberId);
    Hunting findById(long id);
}
