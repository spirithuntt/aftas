package youcode.aftas.controller;

import org.springframework.http.ResponseEntity;
import youcode.aftas.domain.Member;

public interface MemberController {
    ResponseEntity<?> getMemberById(Long id);
    ResponseEntity<?> addMember(Member member);
    ResponseEntity<?> searchMemberByName(String name);
    ResponseEntity<?> updateMember(Member member, Long id);
    ResponseEntity<?> deleteMember(Long id);

}
