package com.example.aftas.repository;

import com.example.aftas.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member getMemberById(Long id);

    List<Member> getMemberByName(String name);

    Member getMemberByIdentityNumber(String identityNumber);

    List<Member> getMemberByNumber(Integer number);

    List<Member> getMemberByNameOrFamilyName(String name, String familyName);

}
