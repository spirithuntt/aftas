package com.example.aftas.dto.responses.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.aftas.domain.Role;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse{
    private String name;
    private String email;
    private String token;
    private Role role;
}
