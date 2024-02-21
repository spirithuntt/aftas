package com.example.aftas.service.auth;

import com.example.aftas.domain.Member;
import org.springframework.stereotype.Component;
import com.example.aftas.domain.Role;

import java.util.Optional;

@Component
public interface UserService {
    Optional<Member> getById(Long id);

    Role grantRoleToUser(Long userId, Long roleId);
}
