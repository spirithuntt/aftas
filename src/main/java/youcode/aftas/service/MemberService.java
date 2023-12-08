package youcode.aftas.service;

import youcode.aftas.domain.Member;

import java.util.List;

public interface MemberService {
    Member getMemberById(Long id);
    Member addMember(Member member);
    List<Member> searchMember(String name);
    Member updateMember(Member member, Long id);
    void deleteMember(Long id);
}
