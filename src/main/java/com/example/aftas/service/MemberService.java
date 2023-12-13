package com.example.aftas.service;

import com.example.aftas.domain.Member;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MemberService {

    Member save(Member member);

    List<Member> getAll();

    Member getById(Long id);

    Member update(Member member, Long id);

    void delete(Long id);

    List<Member> getByName(String name);

    List<Member> getByIdentityNumber(String identityNumber);

    List<Member> getByNameOrFamilyNameOrNumber(String searchParam);

}
