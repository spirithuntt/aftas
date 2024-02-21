package com.example.aftas.dto.responses.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.aftas.domain.Authority;
import com.example.aftas.domain.Role;
import com.example.aftas.domain.enums.AuthorityEnum;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleResponseDTO{
    private String name;
    private List<AuthorityEnum> authorities;
    private boolean isDefault;


    public static RoleResponseDTO fromRole(Role role){
        return RoleResponseDTO.builder()
                .name(role.getName())
                .authorities(role.getAuthorities().stream().map(Authority::getName).toList())
                .isDefault(role.isDefault())
                .build();
    }

}

