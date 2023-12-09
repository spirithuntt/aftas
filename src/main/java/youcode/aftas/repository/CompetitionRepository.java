package youcode.aftas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import youcode.aftas.domain.Competition;

import java.util.Date;
import java.util.List;

public interface CompetitionRepository extends JpaRepository<Competition, Long> {

    List<Competition> findByDate(String date);
}