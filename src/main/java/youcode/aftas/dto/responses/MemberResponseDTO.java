package youcode.aftas.dto.responses;


import youcode.aftas.domain.Member;
import youcode.aftas.enums.IdentityDocumentType;

import java.time.LocalDate;
import java.util.Date;

public record MemberResponseDTO(
        String name,
        String familyName,
        Date accessDate,
        String nationality,
        IdentityDocumentType identityDocumentType,
        String identityNumber
) {
    public static MemberResponseDTO fromMember(Member member){
        return new MemberResponseDTO(
                member.getName(),
                member.getFamilyName(),
                member.getAccessDate(),
                member.getNationality(),
                member.getIdentityDocumentType(),
                member.getIdentityNumber()
        );
    }
}
