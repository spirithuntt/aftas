package com.example.aftas.service.implementation;

import com.example.aftas.domain.Member;
import com.example.aftas.repository.MemberRepository;
import com.example.aftas.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Member save(Member member) {
        List<Member> members = getAll();
        member.setNumber(ThreadLocalRandom.current().nextInt(100000, 1000000));
        while (!members.stream().filter(member1 -> member1.getNumber().equals(member.getNumber())).toList().isEmpty()){
            member.setNumber(ThreadLocalRandom.current().nextInt(100000, 1000000));
        }
        member.setAccessionDate(LocalDate.now());
        return memberRepository.save(member);
    }

    @Override
    public List<Member> getAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member getById(Long id) {
        return memberRepository.getMemberById(id);
    }

    @Override
    public Member update(Member member, Long id) {
        Member existingMember = getById(id);
        if (existingMember != null){
            existingMember.setName(member.getName());
            existingMember.setNationality(member.getNationality());
            existingMember.setFamilyName(member.getFamilyName());
            existingMember.setIdentityDocumentType(member.getIdentityDocumentType());
            existingMember.setIdentityNumber(member.getIdentityNumber());

            return memberRepository.save(existingMember);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        Member member = getById(id);
        if (member != null) memberRepository.delete(member);
    }

    @Override
    public List<Member> getByName(String name) {
        return memberRepository.getMemberByName(name);
    }

    @Override
    public List<Member> getByIdentityNumber(String identityNumber) {
        return memberRepository.getMemberByIdentityNumber(identityNumber);
    }

    @Override
    public Member getByNumber(Integer number) {
        return memberRepository.getMemberByNumber(number);
    }

    @Override
    public List<Member> getByNameOrFamilyNameOrNumber(String searchParam) {
        return memberRepository.findByNumberOrFirstNameOrLastName(searchParam);
    }

    @Override
    public Member getByEmail(String email) {
        return memberRepository.getByEmail(email);
    }
}
