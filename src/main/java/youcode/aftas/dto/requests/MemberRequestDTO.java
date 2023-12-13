package youcode.aftas.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import youcode.aftas.domain.Member;
import youcode.aftas.enums.IdentityDocumentType;

import java.util.Date;

public record MemberRequestDTO(
        @NotNull(message = "Name can't be null")
        @NotBlank(message = "Name can't be blank")
        @Size(max = 50, min = 2, message = "Name must be between 2 and 50 characters")
        String name,

        @NotNull(message = "Family name can't be null")
        @NotBlank(message = "Family name can't be blank")
        @Size(max = 50, min = 2, message = "Family name must be between 2 and 50 characters")
        String familyName,


        //accessDate
        @NotNull(message = "Access date can't be null")
        @NotBlank(message = "Access date can't be blank")
        @Size(max = 50, min = 2, message = "Access date must be between 2 and 50 characters")
        Date accessDate,


        @NotNull(message = "Nationality can't be null")
        @NotBlank(message = "Nationality can't be blank")
        @Size(max = 50, min = 2, message = "Nationality must be between 2 and 50 characters")
        String nationality,

        IdentityDocumentType identityDocumentType,

        @NotNull(message = "Identity number can't be null")
        @NotBlank(message = "Identity number can't be blank")
        @Size(max = 50, min = 2, message = "Identity number must be between 2 and 50 characters")
        String identityNumber
) {
    public Member toMember() {
        return Member.builder()
                .name(name)
                .familyName(familyName)
                .accessDate(accessDate)
                .nationality(nationality)
                .identityDocumentType(identityDocumentType)
                .identityNumber(identityNumber)
                .build();
    }
}
