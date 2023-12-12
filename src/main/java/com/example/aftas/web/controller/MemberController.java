package com.example.aftas.web.controller;

import com.example.aftas.domain.Member;
import com.example.aftas.dto.requests.MemberRequestDTO;
import com.example.aftas.dto.responses.MemberResponseDTO;
import com.example.aftas.handler.response.ResponseMessage;
import com.example.aftas.service.MemberService;
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
        List<MemberResponseDTO> members = memberService.getAll();
        if (members.isEmpty()) return ResponseMessage.notFound("No member was found");
        else return ResponseMessage.ok("Members fetched successfully", members);
    }

    @GetMapping("/{id}")
    public ResponseEntity getMemberById(@PathVariable Long id){
        MemberResponseDTO member = memberService.getById(id);
        if(member == null) return ResponseMessage.notFound("Member not found");
        else return ResponseMessage.ok("Success", member);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity getMemberByName(@PathVariable String name){
        List<MemberResponseDTO> members = memberService.getByName(name);
        if(members.isEmpty()) return ResponseMessage.notFound("No member was found");
        else return ResponseMessage.ok("Success", members);
    }

    @GetMapping("/identity_number/{identityNumber}")
    public ResponseEntity getMemberByIdentityNumber(@PathVariable String identityNumber){
        MemberResponseDTO member = memberService.getByIdentityNumber(identityNumber);
        if(member == null) return ResponseMessage.notFound("Member not found");
        else return ResponseMessage.ok("Success", member);
    }

    @GetMapping("/search/{searchParam}")
    public ResponseEntity getMemberByNameOrFamilyNameOrNumber(@PathVariable String searchParam){
        List<MemberResponseDTO> members = memberService.getByNameOrFamilyNameOrNumber(searchParam);
        if(members.isEmpty()) return ResponseMessage.notFound("No member was found");
        else return ResponseMessage.ok("Success", members);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody MemberRequestDTO member){
        MemberResponseDTO member1 = memberService.save(member);
        if (member1 == null) return ResponseMessage.badRequest("bad request");
        else return ResponseMessage.created("Member created successfully", member1);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody MemberRequestDTO member, @PathVariable Long id){
        MemberResponseDTO member1 = memberService.update(member, id);
        if (member1 == null) return ResponseMessage.badRequest("bad request");
        else return ResponseMessage.created("Member updated successfully", member1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        MemberResponseDTO member = memberService.getById(id);
        if (member == null) return ResponseMessage.notFound("Member not found");
        else {
            memberService.delete(id);
            return ResponseMessage.ok("Member deleted successfully", member);
        }
    }

}
