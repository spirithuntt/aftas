package youcode.aftas.controller.Impl;

import youcode.aftas.controller.MemberController;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import youcode.aftas.domain.Member;
import youcode.aftas.handler.response.ResponseMessage;
import youcode.aftas.service.MemberService;



import java.util.List;

@RestController
@RequestMapping("/api/members")

public class MemberControllerImpl implements MemberController {
    private final MemberService memberService;

    public MemberControllerImpl(MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping("/{id}")
    public ResponseEntity getMemberById(@PathVariable Long id) {
        Member member = memberService.getMemberById(id);
        if(member == null) {
            return ResponseMessage.notFound("Member not found");
        }else {
            return ResponseMessage.ok( "Success", member);
        }
    }

    @PostMapping
    public ResponseEntity addMember(@Valid @RequestBody Member member) {
        Member member1 = memberService.addMember(member);
        if(member1 == null) {
            return ResponseMessage.badRequest("Member not created");
        }else {
            return ResponseMessage.created("Member created successfully", member1);
        }
    }

    @GetMapping
    public ResponseEntity searchMemberByName(@RequestBody String name) {
        List<Member> members = memberService.searchMemberByName(name);
        if(members.isEmpty()) {
            return ResponseMessage.notFound("Member not found");
        }else {
            return ResponseMessage.ok("Success", members);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateMember(@RequestBody Member member, @PathVariable Long id) {
        Member member1 = memberService.updateMember(member, id);
        if(member1 == null) {
            return ResponseMessage.badRequest("Member not updated");
        }else {
            return ResponseMessage.created("Member updated successfully", member1);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMember(@PathVariable Long id) {
        Member member = memberService.getMemberById(id);
        if(member == null) {
            return ResponseMessage.notFound("Member not found");
        }else {
            memberService.deleteMember(id);
            return ResponseMessage.ok("Member deleted successfully", member);
        }
    }
}
