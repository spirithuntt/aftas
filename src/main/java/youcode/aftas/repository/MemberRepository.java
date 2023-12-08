package youcode.aftas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import youcode.aftas.domain.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    public List<Member> findByName(String name);
}
