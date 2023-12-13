package youcode.aftas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import youcode.aftas.domain.Fish;

import java.util.List;

@Repository
public interface FishRepository extends JpaRepository<Fish, Long> {
    Boolean existsByName(String name);
    List<Fish> findAllByOrderByLevelAsc();
    Fish findById(long id);

}
