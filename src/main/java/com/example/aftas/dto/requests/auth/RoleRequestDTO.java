package com.example.aftas.dto.requests.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.aftas.domain.Authority;
import com.example.aftas.domain.Role;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleRequestDTO{
    private String name;
    private List<Authority> authorities;
    private boolean isDefault;

    public Role toRole(){
        return Role.builder()
                .name(name)
                .authorities(authorities)
                .isDefault(isDefault)
                .build();
    }
}