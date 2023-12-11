package youcode.aftas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import youcode.aftas.domain.Level;
import youcode.aftas.domain.Member;

import java.util.List;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long>{
    List<Level> findByName(String name);

    boolean existsByPointsGreaterThanEqual(int points);

    boolean existsByPointsLessThanEqual(int points);

    boolean existsByPoints(int points);


    boolean existsByShootingLevel(int shootingLevel);


}
