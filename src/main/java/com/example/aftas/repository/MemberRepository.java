package com.example.aftas.repository;

import com.example.aftas.domain.Member;

import java.util.List;

public interface MemberRepository {

    Member save(Member member);

    List<Member> getAll();

    Member getById(Long id);

    Member update(Member member);

    void delete(Long id);

    List<Member> getByNameMembers(String name);

    Member getByIdentityNumberMember(String identityNumber);

}
