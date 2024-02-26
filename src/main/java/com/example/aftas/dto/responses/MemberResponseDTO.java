package com.example.aftas.dto.responses;

import com.example.aftas.domain.Member;
import com.example.aftas.domain.enums.IdentityDocumentType;

import java.time.LocalDate;

public record MemberResponseDTO(

    Integer number,
    String name,
    String familyName,
    LocalDate accessionDate,
    String nationality,
    IdentityDocumentType identityDocumentType,
    String identityNumber,
    Boolean accountLocked
) {
    public static MemberResponseDTO fromMember(Member member){
        return new MemberResponseDTO(
                member.getNumber(),
                member.getName(),
                member.getFamilyName(),
                member.getAccessionDate(),
                member.getNationality(),
                member.getIdentityDocumentType(),
                member.getIdentityNumber(),
                member.isAccountNotLocked()
        );
    }
}
