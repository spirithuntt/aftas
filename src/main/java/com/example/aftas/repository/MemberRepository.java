package com.example.aftas.repository;

import com.example.aftas.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member getMemberById(Long id);

    List<Member> getMemberByName(String name);

    List<Member> getMemberByIdentityNumber(String identityNumber);

    Member getMemberByNumber(Integer number);

    @Query(value =
            "SELECT * FROM member WHERE number LIKE %:searchTerm% " +
                    "OR name LIKE %:searchTerm% OR family_name LIKE %:searchTerm%", nativeQuery = true)
    List<Member> findByNumberOrFirstNameOrLastName(@Param("searchTerm") String searchTerm);

}
