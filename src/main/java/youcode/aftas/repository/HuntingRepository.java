package youcode.aftas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import youcode.aftas.domain.Hunting;

@Repository
public interface HuntingRepository extends JpaRepository<Hunting, Long>{
}
