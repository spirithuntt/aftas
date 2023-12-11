package youcode.aftas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import youcode.aftas.domain.Competition;
import youcode.aftas.domain.Member;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    //L’interface admin doit permettre la recherche d’un adhérent par numéro, nom, ou prénom.
     List<Member> findByName(String name);

     List<Member> findByFamilyName(String familyName);

     List<Member> findByIdentityNumber(String identityNumber);

    boolean existsByRankings_Competition(Competition competition);


}
