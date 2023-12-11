package youcode.aftas.service;

import org.springframework.stereotype.Service;
import youcode.aftas.domain.Member;

import java.util.List;

@Service
public interface MemberService {
    Member getMemberById(Long id);
    Member addMember(Member member);
    List<Member> searchMember(String name);
    Member updateMember(Member member, Long id);
    void deleteMember(Long id);
}
