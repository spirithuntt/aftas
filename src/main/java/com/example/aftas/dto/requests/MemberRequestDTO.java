package com.example.aftas.dto.requests;

import com.example.aftas.domain.Member;
import com.example.aftas.domain.enums.IdentityDocumentType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record MemberRequestDTO(

    @NotNull(message = "Name can't be null")
    @NotBlank(message = "Name can't be blank")
    @Size(max = 50, min = 2, message = "Name must be between 2 and 50 characters")
    String name,

    @NotNull(message = "Family name can't be null")
    @NotBlank(message = "Family name can't be blank")
    @Size(max = 50, min = 2, message = "Family name must be between 2 and 50 characters")
    String familyName,

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
                .nationality(nationality)
                .identityDocumentType(identityDocumentType)
                .identityNumber(identityNumber)
                .build();
    }
}
