package com.example.aftas.web.controller;

import com.example.aftas.domain.Member;
import com.example.aftas.dto.requests.MemberRequestDTO;
import com.example.aftas.dto.responses.MemberResponseDTO;
import com.example.aftas.handler.response.ResponseMessage;
import com.example.aftas.service.MemberService;
import jakarta.validation.Valid;
import jdk.jfr.MemoryAddress;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public ResponseEntity getAll(){
        List<Member> members = memberService.getAll();
        if (members.isEmpty()) return ResponseMessage.notFound("No member was found");
        else return ResponseMessage.ok("Members fetched successfully", members.stream().map(MemberResponseDTO::fromMember).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity getMemberById(@PathVariable Long id){
        Member member = memberService.getById(id);
        if(member == null) return ResponseMessage.notFound("Member not found");
        else return ResponseMessage.ok("Success", MemberResponseDTO.fromMember(member));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity getMemberByName(@PathVariable String name){
        List<Member> members = memberService.getByName(name);
        if(members.isEmpty()) return ResponseMessage.notFound("No member was found");
        else return ResponseMessage.ok("Success", members.stream().map(MemberResponseDTO::fromMember).toList());
    }

    @GetMapping("/identity_number/{identityNumber}")
    public ResponseEntity getMemberByIdentityNumber(@PathVariable String identityNumber){
        List<Member> members = memberService.getByIdentityNumber(identityNumber);
        if(members.isEmpty()) return ResponseMessage.notFound("Member not found");
        else return ResponseMessage.ok("Success", members.stream().map(MemberResponseDTO::fromMember).toList());
    }

    @GetMapping("/search/{searchParam}")
    public ResponseEntity getMemberByNameOrFamilyNameOrNumber(@PathVariable String searchParam){
        List<Member> members = memberService.getByNameOrFamilyNameOrNumber(searchParam);
        if(members.isEmpty()) return ResponseMessage.notFound("No member was found");
        else return ResponseMessage.ok("Success", members.stream().map(MemberResponseDTO::fromMember).toList());
    }

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid MemberRequestDTO member){
        Member member1 = memberService.save(member.toMember());
        if (member1 == null) return ResponseMessage.badRequest("bad request");
        else return ResponseMessage.created("Member created successfully", MemberResponseDTO.fromMember(member1));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody @Valid MemberRequestDTO member, @PathVariable Long id){
        Member member1 = memberService.update(member.toMember(), id);
        if (member1 == null) return ResponseMessage.badRequest("bad request");
        else return ResponseMessage.created("Member updated successfully", MemberResponseDTO.fromMember(member1));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        Member member = memberService.getById(id);
        if (member == null) return ResponseMessage.notFound("Member not found");
        else {
            memberService.delete(id);
            return ResponseMessage.ok("Member deleted successfully", MemberResponseDTO.fromMember(member));
        }
    }

}
