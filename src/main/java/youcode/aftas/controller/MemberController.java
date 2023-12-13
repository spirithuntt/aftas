package youcode.aftas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import youcode.aftas.domain.Member;

@Controller
public interface MemberController {
    ResponseEntity<?> getMemberById(Long id);
    ResponseEntity<?> addMember(Member member);
    ResponseEntity<?> searchMemberByName(String name);
    ResponseEntity<?> updateMember(Member member, Long id);
    ResponseEntity<?> deleteMember(Long id);

}
