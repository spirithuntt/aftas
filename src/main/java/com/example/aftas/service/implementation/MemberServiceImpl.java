package com.example.aftas.service.implementation;

import com.example.aftas.domain.Member;
import com.example.aftas.service.MemberService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Override
    public Member save(Member member) {
        return null;
    }

    @Override
    public List<Member> getAll() {
        return null;
    }

    @Override
    public Member getById(Long id) {
        return null;
    }

    @Override
    public Member update(Member member, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {}

    @Override
    public List<Member> getByName(String name) {
        return null;
    }

    @Override
    public Member getByIdentityNumber(String identityNumber) {
        return null;
    }

    public List<Member> getByNameOrFamilyNameOrNumber(String searchParam){ return null; }

}
